package io.github.samanthatovah.merchantnavy.domain.transportschedule;

import io.github.samanthatovah.merchantnavy.domain.fleet.Fleet;
import io.github.samanthatovah.merchantnavy.domain.fleet.FleetService;
import io.github.samanthatovah.merchantnavy.domain.moveorder.MoveOrderService;
import io.github.samanthatovah.merchantnavy.domain.planetaryinstallation.PlanetaryInstallationService;
import io.github.samanthatovah.merchantnavy.domain.popinstallationdemand.PopInstallationDemand;
import io.github.samanthatovah.merchantnavy.domain.popinstallationdemand.PopInstallationDemandService;
import io.github.samanthatovah.merchantnavy.domain.population.Population;
import io.github.samanthatovah.merchantnavy.domain.population.PopulationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class TransportScheduleService {

	private final PopInstallationDemandService popInstallationDemandService;
	private final PopulationService populationService;
	private final PlanetaryInstallationService planetaryInstallationService;
	private final FleetService fleetService;
	private final MoveOrderService moveOrderService;

	public TransportSchedule planFleet(Fleet fleet) throws TransportScheduleException {
		if (!fleetService.isFleetEmptyCargo(fleet)) {
			throw new TransportScheduleException("Merchant Navy fleet \"" + fleet.name() + "\" has no orders but non-empty cargo");
		}
		log.info("Merchant Navy fleet waiting for order: {} - {}", fleet.name(), fleet);
		int systemId = fleet.systemId();
		var demands = popInstallationDemandService.getAll();
		var imports = demands.stream().filter(d -> !d.export()).toList();
		var exports = demands.stream().filter(d -> d.export()).toList();

		// Find a matching import and export in the fleet's system
		TransportSchedule transportSchedule = getIntraSystemTransportSchedule(fleet, imports, exports, systemId);

		return transportSchedule;
	}

	private TransportSchedule getIntraSystemTransportSchedule(Fleet fleet, List<PopInstallationDemand> imports,
															  List<PopInstallationDemand> exports, int systemId) {
		for (var imp : imports) {
			Optional<PopInstallationDemand> matchingExport = exports.stream()
					.filter(exp -> populationService.isInSameSystem(exp.populationId(), imp.populationId())
							&& exp.installationId() == imp.installationId()
							&& exp.gameId() == imp.gameId())
					.findFirst();

			if (matchingExport.isPresent()) {
				PopInstallationDemand exp = matchingExport.get();
				Population exportPopulation = populationService.getPopulation(exp.populationId());
				Population importPopulation = populationService.getPopulation(imp.populationId());
				var installation = planetaryInstallationService.getPlanetaryInstallation(imp.installationId());
				float exportDemand = exp.amount();
				float importDemand = imp.amount();
				float cargoCapacity = fleetService.getFleetCargoCapacity(fleet);
				int installationSize = installation.cargoPoints();
				float matchingDemand = Math.min(exportDemand, importDemand);
				float maxInstallationsCarried = cargoCapacity / installationSize;
				float installationsCarried = Math.min(matchingDemand, maxInstallationsCarried);

				log.info("{} wants to export {} {}",
						populationService.getPopulation(exp.populationId()).name(), exportDemand, installation.name());
				log.info("{} wants to import {} {}",
						populationService.getPopulation(imp.populationId()).name(), importDemand, installation.name());
				log.info("\"{}\" has a total cargo capacity of {}, and can carry {} {}",
						fleet.name(), cargoCapacity, maxInstallationsCarried, installation.name());
				log.info("Creating transport schedule of {} {} from {} to {} within {} for fleet \"{}\"",
						installationsCarried, installation.name(), exportPopulation.name(), importPopulation.name(), systemId, fleet.name());

				return new TransportSchedule(
						installation,
						installationsCarried,
						exportPopulation,
						importPopulation,
						fleet
				);
			}
		}

		return null;
	}
}
