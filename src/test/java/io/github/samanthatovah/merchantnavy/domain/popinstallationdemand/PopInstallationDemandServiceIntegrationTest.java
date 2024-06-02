package io.github.samanthatovah.merchantnavy.domain.popinstallationdemand;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class PopInstallationDemandServiceIntegrationTest {

	@Autowired
	private PopInstallationDemandService popInstallationDemandService;

	@Test
	void getPopulation() {
		List<PopInstallationDemand> popInstallationDemands = popInstallationDemandService.getAll();
		for (PopInstallationDemand population : popInstallationDemands) {
			log.info("Pop Installation Demand: {}", population);
		}
	}

}
