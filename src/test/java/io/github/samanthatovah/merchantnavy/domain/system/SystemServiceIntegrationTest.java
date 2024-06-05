package io.github.samanthatovah.merchantnavy.domain.system;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class SystemServiceIntegrationTest {

	@Autowired
	SystemService systemService;

	@Test
	void getAll() {
		List<System> systems = systemService.getAll();
		for (System system : systems) {
			log.info("System: {}", system);
		}
	}

}