package io.github.samanthatovah.merchantnavy.domain.ship;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class ShipServiceIntegrationTest {

	@Autowired
	private ShipService shipService;

	@Test
	void getAll() {
		List<Ship> ships = shipService.getAll();
		for (Ship ship : ships) {
			log.info("Ship: {}", ship);
		}
	}

}