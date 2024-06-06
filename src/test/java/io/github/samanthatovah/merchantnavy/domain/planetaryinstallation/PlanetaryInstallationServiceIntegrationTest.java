package io.github.samanthatovah.merchantnavy.domain.planetaryinstallation;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class PlanetaryInstallationServiceIntegrationTest {

	@Autowired
	private PlanetaryInstallationService planetaryInstallationService;

	@Test
	void repositoryTest() {
		PlanetaryInstallation fuelRefinery = planetaryInstallationService.getPlanetaryInstallation(3);
		PlanetaryInstallation spaceport = planetaryInstallationService.getPlanetaryInstallation(33);
		PlanetaryInstallation lowGravityInfrastructure = planetaryInstallationService.getPlanetaryInstallation(41);

		assertEquals("Fuel Refinery", fuelRefinery.name());
		assertEquals(25000, fuelRefinery.cargoPoints());
		assertEquals("Spaceport", spaceport.name());
		assertEquals(1000000, spaceport.cargoPoints());
		assertEquals("Low Gravity Infrastructure", lowGravityInfrastructure.name());
		assertEquals(2500, lowGravityInfrastructure.cargoPoints());

		log.info("fuel refinery: {}", fuelRefinery);
	}

	@Test
	void getAll() {
		List<PlanetaryInstallation> planetaryInstallations = planetaryInstallationService.getAll();
		for (PlanetaryInstallation planetaryInstallation : planetaryInstallations) {
			log.info("Planetary Installation: {}", planetaryInstallation);
		}
	}

}
