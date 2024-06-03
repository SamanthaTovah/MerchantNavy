package io.github.samanthatovah.merchantnavy;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.domain.game.GameService;
import io.github.samanthatovah.merchantnavy.domain.moveaction.MoveActionService;
import io.github.samanthatovah.merchantnavy.domain.planetaryinstallation.PlanetaryInstallationService;
import io.github.samanthatovah.merchantnavy.domain.popinstallationdemand.PopInstallationDemandService;
import io.github.samanthatovah.merchantnavy.domain.population.PopulationService;
import io.github.samanthatovah.merchantnavy.domain.race.RaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
@Profile("!test")
public class MerchantNavyRunner implements CommandLineRunner {

	private final GameService gameService;
	private final MoveActionService moveActionService;
	private final PlanetaryInstallationService planetaryInstallationService;
	private final PopInstallationDemandService popInstallationDemandService;
	private final PopulationService populationService;
	private final RaceService raceService;

	@Override
	public void run(String... args) {
		GenericRepository.GAME_ID = gameService.getGame().id();
		log.info("Set GAME_ID to {}", GenericRepository.GAME_ID);

		// TODO find all fleets

		// TODO loop through all Merchant Navy fleets without orders

		// TODO if they have cargo or don't have full fuel, log error?

		// TODO for each fleet, see if there's an inter-system job to do in their system

		// TODO if not, see if there is an intra-system job with export in their system

		// TODO if not, see if there is an intra-system job with import in their system

		// TODO if not, either wait, or see intra-system without import or export in this system?

		// exit
		System.exit(0);
	}
}
