package io.github.samanthatovah.merchantnavy.domain.shipcargo;

import io.github.samanthatovah.merchantnavy.domain.ship.Ship;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class ShipCargoService {

	private final ShipCargoRepository repository;

	public List<ShipCargo> getAll() {
		return repository.getAll();
	}

	public List<ShipCargo> getShipCargoByShip(Ship ship) {
		return repository.getByShipId(ship.id());
	}
}
