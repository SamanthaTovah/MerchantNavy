package io.github.samanthatovah.merchantnavy.domain.shipclass;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class ShipClassService {

	private final ShipClassRepository repository;

	public List<ShipClass> getAll() {
		return repository.getAll();
	}

	public ShipClass getShipClass(int id) {
		return repository.get(id);
	}
}
