package io.github.samanthatovah.merchantnavy.domain.population;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class PopulationService {

	private final PopulationRepository repository;

	public List<Population> getAll() {
		return repository.getAll();
	}

	public Population getPopulation(int id) {
		return repository.get(id);
	}

	public boolean isInSameSystem(int populationIdA, int populationIdB) {
		int systemIdA = repository.get(populationIdA).systemBodyId();
		int systemIdB = repository.get(populationIdB).systemId();
		return systemIdA == systemIdB;
	}
}
