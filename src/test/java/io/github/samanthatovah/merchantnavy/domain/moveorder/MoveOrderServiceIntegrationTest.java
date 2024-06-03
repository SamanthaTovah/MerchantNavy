package io.github.samanthatovah.merchantnavy.domain.moveorder;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class MoveOrderServiceIntegrationTest {

	@Autowired
	private MoveOrderService moveOrderService;

	@Test
	void getAll() {
		List<MoveOrder> moveOrders = moveOrderService.getAll();
		for (MoveOrder moveOrder : moveOrders) {
			log.info("Move Order: {}", moveOrder);
		}
	}

}