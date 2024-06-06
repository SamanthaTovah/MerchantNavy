package io.github.samanthatovah.merchantnavy.domain.planetaryinstallation;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class PlanetaryInstallationService {

	private final PlanetaryInstallationRepository repository;

	public List<PlanetaryInstallation> getAll() {
		return repository.getAll();
	}

	public PlanetaryInstallation getPlanetaryInstallation(int id) {
		return repository.get(id);
	}

	public PlanetaryInstallation getByName(String name) {
		return repository.getByName(name);
	}
}
