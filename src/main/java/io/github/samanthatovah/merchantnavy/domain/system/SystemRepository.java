package io.github.samanthatovah.merchantnavy.domain.system;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemRepository extends GenericRepository<System> {

	public SystemRepository(DatabaseService databaseService, SystemParser parser) {
		super(databaseService, parser);
	}

	public List<System> getAll() {
		String query = "SELECT * FROM FCT_System WHERE GameID = %d;"
				.formatted(GAME_ID);
		return getAllFromQuery(query);
	}

	public System get(int id) {
		String query = "SELECT * FROM FCT_System WHERe GameID = %d AND SystemID = %d;"
				.formatted(GAME_ID, id);
		return getOneFromQuery(query);
	}
}
