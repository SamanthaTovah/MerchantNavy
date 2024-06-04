package io.github.samanthatovah.merchantnavy;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.domain.fleet.Fleet;
import io.github.samanthatovah.merchantnavy.domain.fleet.FleetService;
import io.github.samanthatovah.merchantnavy.domain.game.GameService;
import io.github.samanthatovah.merchantnavy.domain.jumppoint.JumpPointService;
import io.github.samanthatovah.merchantnavy.domain.moveaction.MoveActionService;
import io.github.samanthatovah.merchantnavy.domain.moveorder.MoveOrderService;
import io.github.samanthatovah.merchantnavy.domain.planetaryinstallation.PlanetaryInstallationService;
import io.github.samanthatovah.merchantnavy.domain.popinstallationdemand.PopInstallationDemandService;
import io.github.samanthatovah.merchantnavy.domain.population.PopulationService;
import io.github.samanthatovah.merchantnavy.domain.race.RaceService;
import io.github.samanthatovah.merchantnavy.domain.ship.ShipService;
import io.github.samanthatovah.merchantnavy.domain.shipclass.ShipClassService;
import io.github.samanthatovah.merchantnavy.domain.transportschedule.TransportSchedule;
import io.github.samanthatovah.merchantnavy.domain.transportschedule.TransportScheduleException;
import io.github.samanthatovah.merchantnavy.domain.transportschedule.TransportScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Component
@Profile("!test")
public class MerchantNavyRunner implements CommandLineRunner {

	private final FleetService fleetService;
	private final GameService gameService;
	private final JumpPointService jumpPointService;
	private final MoveActionService moveActionService;
	private final MoveOrderService moveOrderService;
	private final PlanetaryInstallationService planetaryInstallationService;
	private final PopInstallationDemandService popInstallationDemandService;
	private final PopulationService populationService;
	private final RaceService raceService;
	private final ShipService shipService;
	private final ShipClassService shipClassService;
	private final TransportScheduleService transportScheduleService;

	@Override
	public void run(String... args) {
		initializeRepositoryValues();

		List<Fleet> waitingFleets = fleetService.getWaitingMerchantNavyFleets();
		for (Fleet fleet : waitingFleets) {
			try {
				TransportSchedule transportSchedule = transportScheduleService.planFleet(fleet);
			} catch (TransportScheduleException e) {
				log.error(e.toString());
			}
		}

		// TODO if they have cargo or don't have full fuel, log error?

		// TODO if not, see if there is an intra-system job with export in their system

		// TODO if not, see if there is an intra-system job with import in their system

		// TODO if not, either wait, or see intra-system without import or export in this system?

		// exit
		System.exit(0);
	}

	private void initializeRepositoryValues() {
		GenericRepository.GAME_ID = gameService.getGame().id();
		GenericRepository.RACE_ID = raceService.getPlayerRace().id();
		log.info("Set GAME_ID to {}", GenericRepository.GAME_ID);
		log.info("Set RACE_ID to {}", GenericRepository.RACE_ID);
	}
}
