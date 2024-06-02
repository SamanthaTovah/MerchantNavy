package io.github.samanthatovah.merchantnavy.domain.planetaryinstallation;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class PlanetaryInstallationService {

	private final PlanetaryInstallationRepository repository;

	public PlanetaryInstallation getPlanetaryInstallation(int id) {
		return repository.get(id);
	}
}
