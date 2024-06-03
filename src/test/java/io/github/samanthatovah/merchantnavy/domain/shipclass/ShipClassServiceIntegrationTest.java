package io.github.samanthatovah.merchantnavy.domain.shipclass;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class ShipClassServiceIntegrationTest {

	@Autowired
	ShipClassService shipClassService;

	@Test
	void getAll() {
		List<ShipClass> shipClasses = shipClassService.getAll();
		for (ShipClass shipClass : shipClasses) {
			log.info("Ship Class: {}", shipClass);
		}
	}

}