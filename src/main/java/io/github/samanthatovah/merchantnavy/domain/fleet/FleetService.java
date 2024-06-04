package io.github.samanthatovah.merchantnavy.domain.fleet;

import io.github.samanthatovah.merchantnavy.domain.moveorder.MoveOrderService;
import io.github.samanthatovah.merchantnavy.domain.ship.ShipService;
import io.github.samanthatovah.merchantnavy.domain.shipclass.ShipClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class FleetService {

	private final FleetRepository repository;
	private final MoveOrderService moveOrderService;
	private final ShipService shipService;
	private final ShipClassService shipClassService;

	public List<Fleet> getAll() {
		return repository.getAll();
	}

	public Fleet getFleet(int id) {
		return repository.get(id);
	}

	public List<Fleet> getWaitingMerchantNavyFleets() {
		return getAll().stream()
				.filter(f -> f.name().endsWith(" - MN") || f.name().endsWith(" [MN]"))
				.filter(f -> moveOrderService.getFleetOrders(f.id()).isEmpty())
				.toList();
	}

	public float getFleetCargoCapacity(Fleet fleet) {
		return (float) shipService.getAll().stream()
				.filter(s -> s.fleetId() == fleet.id())
				.map(s -> shipClassService.getShipClass(s.shipClassId()))
				.map(sc -> sc.cargoCapacity())
				.mapToDouble(value -> value)
				.sum();
	}
}
