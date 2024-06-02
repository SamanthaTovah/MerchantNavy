package io.github.samanthatovah.merchantnavy.domain.race;

import io.github.samanthatovah.merchantnavy.common.Repository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceRepository extends Repository<Race> {

	public RaceRepository(DatabaseService databaseService, RaceParser parser) {
		super(databaseService, parser);
	}

	public List<Race> getAll() {
		String query = "SELECT * FROM FCT_Race WHERE GameId = " + gameId + ";";
		return getAllFromQuery(query);
	}

	public Race getPlayerRace() {
		String query = "SELECT * FROM FCT_Race WHERE GameId = " + gameId + " AND NPR = 0";
		return getOneFromQuery(query);
	}
}
