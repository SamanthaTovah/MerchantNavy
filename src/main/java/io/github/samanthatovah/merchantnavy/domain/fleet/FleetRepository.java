package io.github.samanthatovah.merchantnavy.domain.fleet;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleetRepository extends GenericRepository<Fleet> {

	public FleetRepository(DatabaseService databaseService, FleetParser parser) {
		super(databaseService, parser);
	}

	public List<Fleet> getAll() {
		String query = "SELECT * FROM FCT_Fleet WHERE GameID = %d AND RaceID = %d;"
				.formatted(GAME_ID, RACE_ID);
		return getAllFromQuery(query);
	}

	public Fleet get(int id) {
		String query = "SELECT * FROM FCT_Fleet WHERE GameID = %d AND AND RaceID = %d AND FleetID = %d;"
				.formatted(GAME_ID, RACE_ID, id);
		return getOneFromQuery(query);
	}
}
