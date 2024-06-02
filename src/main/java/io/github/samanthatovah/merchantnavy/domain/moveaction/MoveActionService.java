package io.github.samanthatovah.merchantnavy.domain.moveaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class MoveActionService {

	private final MoveActionGenericRepository repository;

	public List<MoveAction> getAll() {
		return repository.getAll();
	}

	public MoveAction getMoveAction(int id) {
		return repository.get(id);
	}
}
