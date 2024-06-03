package io.github.samanthatovah.merchantnavy.domain.jumppoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class JumpPointService {

	private final JumpPointRepository repository;

	public List<JumpPoint> getAll() {
		return repository.getAll();
	}

	public JumpPoint getJumpPoint(int id) {
		return repository.get(id);
	}
}
