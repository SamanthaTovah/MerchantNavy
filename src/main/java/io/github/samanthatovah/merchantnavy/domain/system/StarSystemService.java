package io.github.samanthatovah.merchantnavy.domain.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class StarSystemService {

	private final StarSystemRepository repository;

	public List<StarSystem> getAll() {
		return repository.getAll();
	}

	public StarSystem getSystem(int id) {
		return repository.get(id);
	}
}
