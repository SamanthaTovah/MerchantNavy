package io.github.samanthatovah.merchantnavy.domain.jumppoint;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class JumpPointServiceIntegrationTest {

	@Autowired
	private JumpPointService jumpPointService;

	@Test
	void getAll() {
		List<JumpPoint> jumpPoints = jumpPointService.getAll();
		for (JumpPoint jumpPoint : jumpPoints) {
			log.info("Jump Point: {}", jumpPoint);
		}
	}

}