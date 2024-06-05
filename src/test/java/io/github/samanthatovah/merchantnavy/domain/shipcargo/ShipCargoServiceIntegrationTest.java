package io.github.samanthatovah.merchantnavy.domain.shipcargo;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class ShipCargoServiceIntegrationTest {

	@Autowired
	private ShipCargoService shipCargoService;

	@Test
	void getAll() {
		List<ShipCargo> shipCargos = shipCargoService.getAll();
		for (ShipCargo shipCargo : shipCargos) {
			log.info("Ship Cargo: {}", shipCargo);
		}
	}

}