package io.github.samanthatovah.merchantnavy.domain.race;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class RaceServiceIntegrationTest {

	@Autowired
	private RaceService raceService;

	@Test
	void getPlayerRace() {
		Race playerRace = raceService.getPlayerRace();

		log.info("player race: {}", playerRace);
	}

}
