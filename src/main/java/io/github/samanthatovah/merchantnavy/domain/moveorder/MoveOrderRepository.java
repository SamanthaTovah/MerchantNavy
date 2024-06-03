package io.github.samanthatovah.merchantnavy.domain.moveorder;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveOrderRepository extends GenericRepository<MoveOrder> {

	public MoveOrderRepository(DatabaseService databaseService, ResultSetParser<MoveOrder> parser) {
		super(databaseService, parser);
	}

	public List<MoveOrder> getAll() {
		String query = "SELECT * FROM FCT_MoveOrders WHERE GameID = %d AND RaceID = %d;"
				.formatted(GAME_ID, RACE_ID);
		return getAllFromQuery(query);
	}

	public MoveOrder get(int id) {
		String query = "SELECT * FROM FCT_MoveOrders WHERE GameID = %d AND RaceID = %d AND MoveOrderID = %d;"
				.formatted(GAME_ID, RACE_ID, id);
		return getOneFromQuery(query);
	}
}
