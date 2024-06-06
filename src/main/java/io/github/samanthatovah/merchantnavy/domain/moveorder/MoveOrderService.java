package io.github.samanthatovah.merchantnavy.domain.moveorder;

import io.github.samanthatovah.merchantnavy.domain.fleet.Fleet;
import io.github.samanthatovah.merchantnavy.domain.population.PopulationService;
import io.github.samanthatovah.merchantnavy.domain.transportschedule.TransportSchedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class MoveOrderService {

	private final MoveOrderRepository repository;
	private final PopulationService populationService;
	private final MoveOrderFactory moveOrderFactory;

	public List<MoveOrder> getAll() {
		return repository.getAll();
	}

	public MoveOrder getMoveOrder(int id) {
		return repository.get(id);
	}

	public List<MoveOrder> getFleetOrders(int id) {
		return getAll().stream()
				.filter(mo -> mo.fleetId() == id)
				.toList();
	}

	public List<MoveOrder> createMoveOrdersFromTransportSchedule(TransportSchedule transportSchedule) {
		// TODO path from system to system
		if (!populationService.isInSameSystem(transportSchedule.importPopulation(), transportSchedule.exportPopulation())) {
			throw new IllegalStateException("Cannot handle pathing between system yet");
		}

		List<MoveOrder> moveOrders = new ArrayList<>();
		// TODO either handle not being able to refuel at start location, or enforce it
		// refuel at export location
		MoveOrder refuelAtColony = moveOrderFactory.createRefuelOrder(transportSchedule.fleet(), transportSchedule.exportPopulation(), getNextMoveOrderForFleet(transportSchedule.fleet()));
		moveOrders.add(refuelAtColony);
		log.info("made \"Refuel at Colony\" MoveOrder: {}", refuelAtColony);

		// load installations

		// move to import location

		// unload installations

		// TODO reconsider this if needed (will need seperate transport actions and refuel actions)
		// move to export location
		log.warn("returning incomplete MoveOrder sequence");
		return moveOrders;
	}

	public int getNextMoveOrderForFleet(Fleet fleet) {
		int max = repository.getByFleetId(fleet.id()).stream()
				.mapToInt(mo -> mo.moveOrder())
				.max()
				.orElse(0);
		return max + 1;
	}

	public void save(MoveOrder moveOrder) {
		repository.save(moveOrder);
	}
}
