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
		String query = "SELECT * FROM FCT_Fleet WHERE GameID = " + GAME_ID + ";";
		return getAllFromQuery(query);
	}

	public Fleet get(int id) {
		String query = "SELECT * FROM FCT_Fleet WHERE GameID = " + GAME_ID + " AND FleetID = " + id + ";";
		return getOneFromQuery(query);
	}
}
