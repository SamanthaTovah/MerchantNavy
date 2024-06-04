package io.github.samanthatovah.merchantnavy.domain.moveorder;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class MoveOrderService {

	private final MoveOrderRepository repository;

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
}
