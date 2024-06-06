package io.github.samanthatovah.merchantnavy.domain.system;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarSystemRepository extends GenericRepository<StarSystem> {

	public StarSystemRepository(DatabaseService databaseService, StarSystemParser parser) {
		super(databaseService, parser);
	}

	public List<StarSystem> getAll() {
		String query = "SELECT * FROM FCT_System WHERE GameID = %d;"
				.formatted(GAME_ID);
		return getAllFromQuery(query);
	}

	public StarSystem get(int id) {
		String query = "SELECT * FROM FCT_System WHERe GameID = %d AND SystemID = %d;"
				.formatted(GAME_ID, id);
		return getOneFromQuery(query);
	}
}
