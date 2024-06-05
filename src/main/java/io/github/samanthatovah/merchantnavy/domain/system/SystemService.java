package io.github.samanthatovah.merchantnavy.domain.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class SystemService {

	private final SystemRepository repository;

	public List<System> getAll() {
		return repository.getAll();
	}

	public System getSystem(int id) {
		return repository.get(id);
	}
}
