package io.github.samanthatovah.merchantnavy.domain.race;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class RaceService {

	private final RaceGenericRepository repository;

	public Race getPlayerRace() {
		return repository.getPlayerRace();
	}
}
