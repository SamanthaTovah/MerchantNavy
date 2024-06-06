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
		int moveOrder = getNextMoveOrderForFleet(transportSchedule.fleet());

		List<MoveOrder> moveOrders = new ArrayList<>();
		// TODO either handle not being able to refuel at start location, or enforce it
		// refuel at export location
		MoveOrder refuelAtColony = moveOrderFactory.createRefuelOrder(transportSchedule.fleet(),
				transportSchedule.exportPopulation(), moveOrder++);
		moveOrders.add(refuelAtColony);
		log.debug("Made \"Refuel at Colony\" MoveOrder: {}", refuelAtColony);

		// load installations at export location
		MoveOrder loadInstallation = moveOrderFactory.createLoadInstallationOrder(transportSchedule.fleet(),
				transportSchedule.exportPopulation(), transportSchedule.cargo(), transportSchedule.cargoAmount(),
				moveOrder++);
		moveOrders.add(loadInstallation);
		log.debug("Made \"Load Installation\" MoveOrder: {}", loadInstallation);

		// unload installations at import location
		MoveOrder unloadInstallation = moveOrderFactory.createUnloadInstallationOrder(transportSchedule.fleet(),
				transportSchedule.importPopulation(), transportSchedule.cargo(), transportSchedule.cargoAmount(),
				moveOrder++);
		moveOrders.add(unloadInstallation);
		log.debug("Made \"Unload Installation\" Move Order: {}", unloadInstallation);

		// reconsider this if needed (will need seperate transport actions and refuel actions)
		// refuel back at export location
		MoveOrder refuelAtColony2 = moveOrderFactory.createRefuelOrder(transportSchedule.fleet(),
				transportSchedule.exportPopulation(), moveOrder);
		moveOrders.add(refuelAtColony2);
		log.debug("Made \"Refuel at Colony\" MoveOrder (return): {}", refuelAtColony2);
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
