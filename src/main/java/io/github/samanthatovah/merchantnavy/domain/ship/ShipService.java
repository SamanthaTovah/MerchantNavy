package io.github.samanthatovah.merchantnavy.domain.ship;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class ShipService {

	private final ShipRepository repository;

	public List<Ship> getAll() {
		return repository.getAll();
	}

	public Ship getShip(int id) {
		return repository.get(id);
	}
}
