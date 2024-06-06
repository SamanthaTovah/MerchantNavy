package io.github.samanthatovah.merchantnavy.domain.moveorder;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.domain.fleet.Fleet;
import io.github.samanthatovah.merchantnavy.domain.moveaction.MoveActionService;
import io.github.samanthatovah.merchantnavy.domain.planetaryinstallation.PlanetaryInstallation;
import io.github.samanthatovah.merchantnavy.domain.population.Population;
import io.github.samanthatovah.merchantnavy.domain.system.StarSystem;
import io.github.samanthatovah.merchantnavy.domain.system.StarSystemService;
import io.github.samanthatovah.merchantnavy.domain.systembody.SystemBodyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class MoveOrderFactory {

	private final MoveActionService moveActionService;
	private final StarSystemService starSystemService;
	private final SystemBodyService systemBodyService;

	public MoveOrder createRefuelOrder(Fleet fleet, Population population, int moveOrder) {
		StarSystem starSystem = starSystemService.getSystem(population.systemId());
		int moveActionId = moveActionService.getIdByDescription("Refuel from Colony");
		int destinationType = 2;
		String description = "%s: Refuel from Colony (MerchantNavy)".formatted(population.name());
		int destinationId = population.systemBodyId();

		return new MoveOrder(
				null,
				GenericRepository.GAME_ID,
				GenericRepository.RACE_ID,
				fleet.id(),
				moveActionId,
				moveOrder,
				starSystem.id(),
				destinationType,
				population.id(),
				0,
				0,
				0.0,
				0,
				0,
				description,
				null, // this might need to be empty String
				0f,
				0,
				0,
				0.0,
				0,
				0.0,
				0,
				0,
				0,
				destinationId
		);
	}

	public MoveOrder createLoadInstallationOrder(Fleet fleet, Population population, PlanetaryInstallation installation,
												 double installationAmount, int moveOrder) {
		StarSystem starSystem = starSystemService.getSystem(population.systemId());
		int moveActionId = moveActionService.getIdByDescription("Load Installation");
		int destinationType = 2; // TODO test with other installations
		int destinationItemType = 2; // TODO test with other installations
		int destinationItemId = installation.id();
		String description = "%s: Load Installation - %s x%d (MerchantNavy)"
				.formatted(population.name(), installation.name(), (int) installationAmount);
		int destinationId = population.systemBodyId();

		return new MoveOrder(
				null,
				GenericRepository.GAME_ID,
				GenericRepository.RACE_ID,
				fleet.id(),
				moveActionId,
				moveOrder,
				starSystem.id(),
				destinationType,
				population.id(),
				destinationItemType,
				destinationItemId,
				installationAmount,
				0,
				0,
				description,
				null,
				0.0,
				0,
				0,
				0.0,
				0,
				0.0,
				0,
				0,
				0,
				destinationId
		);
	}

	public MoveOrder createUnloadInstallationOrder(Fleet fleet, Population population, PlanetaryInstallation installation,
												   double installationAmount, int moveOrder) {
		StarSystem starSystem = starSystemService.getSystem(population.systemId());
		int moveActionId = moveActionService.getIdByDescription("Unload Installation");
		int destinationType = 2; // TODO test with other installations
		int destinationItemType = 19; // TODO test with other installations
		int destinationItemId = installation.id();
		String description = "%s: Unload Installation - %s x%d (MerchantNavy)"
				.formatted(population.name(), installation.name(), (int) installationAmount);
		int destinationId = population.systemBodyId();

		return new MoveOrder(
				null,
				GenericRepository.GAME_ID,
				GenericRepository.RACE_ID,
				fleet.id(),
				moveActionId,
				moveOrder,
				starSystem.id(),
				destinationType,
				population.id(),
				destinationItemType,
				destinationItemId,
				installationAmount,
				0,
				0,
				description,
				null,
				0.0,
				0,
				0,
				0.0,
				0,
				0.0,
				0,
				0,
				0,
				destinationId
		);
	}
}
