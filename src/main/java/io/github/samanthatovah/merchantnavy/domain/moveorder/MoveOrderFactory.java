package io.github.samanthatovah.merchantnavy.domain.moveorder;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.domain.fleet.Fleet;
import io.github.samanthatovah.merchantnavy.domain.moveaction.MoveActionService;
import io.github.samanthatovah.merchantnavy.domain.population.Population;
import io.github.samanthatovah.merchantnavy.domain.system.StarSystem;
import io.github.samanthatovah.merchantnavy.domain.system.StarSystemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class MoveOrderFactory {

	private final MoveActionService moveActionService;
	private final StarSystemService starSystemService;

	public MoveOrder createRefuelOrder(Fleet fleet, Population population, int moveOrder) {
		StarSystem starSystem = starSystemService.getSystem(population.systemId());

		int moveActionId = moveActionService.getIdByDescription("Refuel from Colony");
		int destinationType = 2;
		String description = "%s: Refuel from Colony (MerchantNavy)".formatted(population.name());

		return new MoveOrder(
				null, // with real database this gets added automatically
				GenericRepository.GAME_ID,
				GenericRepository.RACE_ID,
				fleet.id(),
				moveActionId,
				moveOrder,
				starSystem.id(),
				destinationType,
				population.id(),
				0,
				0,
				0.0,
				0,
				0,
				description,
				null, // this might need to be empty String
				0f,
				0,
				0,
				0.0,
				0,
				0.0,
				0,
				0,
				0
		);
	}
}
