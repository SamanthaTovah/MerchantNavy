package io.github.samanthatovah.merchantnavy.domain.fleet;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class FleetServiceIntegrationTest {

	@Autowired
	private FleetService fleetService;

	@Test
	void getAll() {
		List<Fleet> fleets = fleetService.getAll();
		for (Fleet fleet : fleets) {
			log.info("Fleet: {}", fleet);
		}
	}

}