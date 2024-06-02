package io.github.samanthatovah.merchantnavy.domain.population;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class PopulationService {

	private final PopulationGenericRepository repository;

	public List<Population> getAll() {
		return repository.getAll();
	}

	public Population getPopulation(int id) {
		return repository.get(id);
	}
}
