package io.github.samanthatovah.merchantnavy.domain.systembody;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class StarSystemBodyServiceIntegrationTest {

	@Autowired
	private SystemBodyService systemBodyService;

	@Test
	void getAll() {
		List<SystemBody> systemBodies = systemBodyService.getAll();
		for (SystemBody systemBody : systemBodies) {
			log.info("System Body: {}", systemBody);
		}
	}

}