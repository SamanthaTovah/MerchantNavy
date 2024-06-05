package io.github.samanthatovah.merchantnavy.domain.systembody;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class SystemBodyService {

	private final SystemBodyRepository repository;

	public List<SystemBody> getAll() {
		return repository.getAll();
	}

	public SystemBody getSystemBody(int id) {
		return repository.get(id);
	}
}
