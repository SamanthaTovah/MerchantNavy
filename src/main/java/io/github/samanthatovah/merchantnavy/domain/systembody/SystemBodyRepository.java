package io.github.samanthatovah.merchantnavy.domain.systembody;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemBodyRepository extends GenericRepository<SystemBody> {

	public SystemBodyRepository(DatabaseService databaseService, SystemBodyParser parser) {
		super(databaseService, parser);
	}

	public List<SystemBody> getAll() {
		String query = "SELECT * FROM FCT_SystemBody WHERE GameID = %d;"
				.formatted(GAME_ID);
		return getAllFromQuery(query);
	}

	public SystemBody get(int id) {
		String query = "SELECT * FROM FCT_SystemBody WHERE GameID = %d AND SystemBodyID = %d;"
				.formatted(GAME_ID, id);
		return getOneFromQuery(query);
	}
}
