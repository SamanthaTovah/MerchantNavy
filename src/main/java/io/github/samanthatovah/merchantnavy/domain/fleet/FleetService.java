package io.github.samanthatovah.merchantnavy.domain.fleet;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class FleetService {

	private final FleetRepository repository;

	public List<Fleet> getAll() {
		return repository.getAll();
	}

	public Fleet getFleet(int id) {
		return repository.get(id);
	}
}
