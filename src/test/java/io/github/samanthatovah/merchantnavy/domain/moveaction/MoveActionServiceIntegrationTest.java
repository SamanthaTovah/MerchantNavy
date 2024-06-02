package io.github.samanthatovah.merchantnavy.domain.moveaction;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class MoveActionServiceIntegrationTest {

	@Autowired
	private MoveActionService moveActionService;

	@Test
	void getMoveActions() {
		MoveAction moveToLocation = moveActionService.getMoveAction(2);
		MoveAction loadColonists = moveActionService.getMoveAction(4);
		MoveAction unloadAllMinerals = moveActionService.getMoveAction(63);

		assertEquals("Move to Location", moveToLocation.description());
		assertEquals("Load Colonists", loadColonists.description());
		assertEquals("Unload All Minerals", unloadAllMinerals.description());

		log.info(moveToLocation);
	}
}
