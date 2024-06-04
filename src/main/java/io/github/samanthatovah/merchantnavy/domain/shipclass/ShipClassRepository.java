package io.github.samanthatovah.merchantnavy.domain.shipclass;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipClassRepository extends GenericRepository<ShipClass> {

	public ShipClassRepository(DatabaseService databaseService, ResultSetParser<ShipClass> parser) {
		super(databaseService, parser);
	}

	public List<ShipClass> getAll() {
		String query = "SELECT * FROM FCT_ShipClass WHERE GameID = %d AND RaceID = %d;"
				.formatted(GAME_ID, RACE_ID);
		return getAllFromQuery(query);
	}

	public ShipClass get(int id) {
		String query = "SELECT * FROM FCT_ShipClass WHERE GameID = %d AND RaceID = %d AND ShipClassID = %d;"
				.formatted(GAME_ID, RACE_ID, id);
		return getOneFromQuery(query);
	}
}
