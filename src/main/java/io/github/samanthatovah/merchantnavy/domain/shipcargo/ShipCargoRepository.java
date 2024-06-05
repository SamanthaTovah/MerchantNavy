package io.github.samanthatovah.merchantnavy.domain.shipcargo;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipCargoRepository extends GenericRepository<ShipCargo> {

	public ShipCargoRepository(DatabaseService databaseService, ResultSetParser<ShipCargo> parser) {
		super(databaseService, parser);
	}

	public List<ShipCargo> getAll() {
		String query = "SELECT * FROM FCT_ShipCargo WHERE GameID = %d;"
				.formatted(GAME_ID);
		return getAllFromQuery(query);
	}

	public List<ShipCargo> getByShipId(int shipId) {
		String query = "SELECT * FROM FCT_ShipCargo WHERE GameID = %d AND ShipID = %d;"
				.formatted(GAME_ID, shipId);
		return getAllFromQuery(query);
	}
}
