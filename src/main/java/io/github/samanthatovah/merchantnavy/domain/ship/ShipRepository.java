package io.github.samanthatovah.merchantnavy.domain.ship;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipRepository extends GenericRepository<Ship> {

	public ShipRepository(DatabaseService databaseService, ShipParser parser) {
		super(databaseService, parser);
	}

	public List<Ship> getAll() {
		String query = "SELECT * FROM FCT_Ship WHERE GameID = %d AND RaceID = %d;"
				.formatted(GAME_ID, RACE_ID);
		return getAllFromQuery(query);
	}

	public Ship get(int id) {
		String query = "SELECT * FROM FCT_Ship WHERE GameID = %d AND RaceID = %d AND ShipID = %d;"
				.formatted(GAME_ID, RACE_ID, id);
		return getOneFromQuery(query);
	}
}
