package io.github.samanthatovah.merchantnavy.domain.race;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceGenericRepository extends GenericRepository<Race> {

	public RaceGenericRepository(DatabaseService databaseService, RaceParser parser) {
		super(databaseService, parser);
	}

	public List<Race> getAll() {
		String query = "SELECT * FROM FCT_Race WHERE GameId = " + GAME_ID + ";";
		return getAllFromQuery(query);
	}

	public Race getPlayerRace() {
		String query = "SELECT * FROM FCT_Race WHERE GameId = " + GAME_ID + " AND NPR = 0";
		return getOneFromQuery(query);
	}
}
