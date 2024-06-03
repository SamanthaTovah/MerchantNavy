package io.github.samanthatovah.merchantnavy.domain.moveaction;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveActionRepository extends GenericRepository<MoveAction> {

	public MoveActionRepository(DatabaseService databaseService, MoveActionParser parser) {
		super(databaseService, parser);
	}

	public List<MoveAction> getAll() {
		String query = "SELECT * FROM DIM_MoveAction;";
		return getAllFromQuery(query);
	}

	public MoveAction get(int id) {
		String query = "SELECT * FROM DIM_MoveAction WHERE MoveActionID = %d;".formatted(id);
		return getOneFromQuery(query);
	}
}
