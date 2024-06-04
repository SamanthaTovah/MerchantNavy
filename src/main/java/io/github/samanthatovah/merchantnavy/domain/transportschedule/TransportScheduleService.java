package io.github.samanthatovah.merchantnavy.domain.transportschedule;

import io.github.samanthatovah.merchantnavy.domain.fleet.Fleet;
import io.github.samanthatovah.merchantnavy.domain.fleet.FleetService;
import io.github.samanthatovah.merchantnavy.domain.planetaryinstallation.PlanetaryInstallationService;
import io.github.samanthatovah.merchantnavy.domain.popinstallationdemand.PopInstallationDemand;
import io.github.samanthatovah.merchantnavy.domain.popinstallationdemand.PopInstallationDemandService;
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

	public TransportSchedule planFleet(Fleet fleet) throws TransportScheduleException {
		// TODO assert that fleet cargo bays are empty
		log.info("Merchant Navy fleet waiting for order: {} - {}", fleet.name(), fleet);
		int systemId = fleet.systemId();
		var demands = popInstallationDemandService.getAll();
		var imports = demands.stream().filter(d -> !d.export()).toList();
		var exports = demands.stream().filter(d -> d.export()).toList();

		// Find a matching import and export in the fleet's system
		TransportSchedule transportSchedule = null;
		transportSchedule = getIntraSystemTransportSchedule(fleet, imports, exports, systemId);

		return transportSchedule;
	}

	private TransportSchedule getIntraSystemTransportSchedule(Fleet fleet, List<PopInstallationDemand> imports,
															  List<PopInstallationDemand> exports, int systemId) {
		for (var imp : imports) {
			Optional<PopInstallationDemand> matchingExport = exports.stream()
					.filter(exp -> !populationService.isInSameSystem(exp.populationId(), imp.populationId())
							&& exp.installationId() == imp.installationId()
							&& exp.gameId() == imp.gameId())
					.findFirst();

			if (matchingExport.isPresent()) {
				PopInstallationDemand exp = matchingExport.get();
				String exportPopulationName = populationService.getPopulation(exp.populationId()).name();
				String importPopulationName = populationService.getPopulation(imp.populationId()).name();
				var installation = planetaryInstallationService.getPlanetaryInstallation(imp.installationId());
				float exportDemand = exp.amount();
				float importDemand = imp.amount();
				float cargoCapacity = fleetService.getFleetCargoCapacity(fleet);
				log.info("{} has a total cargo capacity of {}", fleet.name(), cargoCapacity);
				int installationSize = installation.cargoPoints();
				float matchingDemand = Math.min(exportDemand, importDemand);
				float maxInstallationsCarried = cargoCapacity / installationSize;
				float installationsCarried = Math.min(matchingDemand, maxInstallationsCarried);
				log.info("Found matching import and export in system {}: {} to {}",
						systemId, exportPopulationName, importPopulationName);
				
				return new TransportSchedule(
						installation,
						installationsCarried,
						exp.populationId(),
						imp.populationId(),
						fleet
				);
			}
		}

		return null;
	}
}
