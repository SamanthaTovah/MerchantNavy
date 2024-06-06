package io.github.samanthatovah.merchantnavy.domain.moveorder;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

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

	public List<MoveOrder> getByFleetId(int fleetId) {
		String query = "SELECT * FROM FCT_MoveOrders WHERE GameID = %d AND RaceID = %d AND FleetID = %d;"
				.formatted(GAME_ID, RACE_ID, fleetId);
		return getAllFromQuery(query);
	}

	public void save(MoveOrder moveOrder) {
		String messageText = moveOrder.messageText() == null ? "NULL" : "'" + moveOrder.messageText() + "'";
		String query = String.format(Locale.US,
				"INSERT INTO FCT_MoveOrders (" +
						"GameID, RaceID, FleetID, MoveActionID, MoveOrder, StartSystemID, DestinationType, " +
						"PopulationID, DestinationItemType, DestinationItemID, MaxItems, NewSystemID, " +
						"NewWarpPointID, Description, MessageText, MinQuantity, OrderDelay, OrbDistance, MinDistance, " +
						"Arrived, SurveyPointsRequired, TimeRequired, LoadSubUnits, OrderDelayRemaining" +
						") VALUES (%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %.2f, %d, %d, '%s', %s, %.2f, %d, %d, %.2f, %d, %.2f, %d, %d, %d)",
				moveOrder.gameId(), moveOrder.raceId(), moveOrder.fleetId(), moveOrder.moveActionId(),
				moveOrder.moveOrder(), moveOrder.startSystemId(), moveOrder.destinationType(),
				moveOrder.populationId(), moveOrder.destinationItemType(), moveOrder.destinationItemId(),
				moveOrder.maxItems(), moveOrder.newSystemId(), moveOrder.newWarpPointId(),
				moveOrder.description(), messageText, moveOrder.minQuantity(),
				moveOrder.orderDelay(), moveOrder.orbDistance(), moveOrder.minDistance(),
				moveOrder.arrived(), moveOrder.surveyPointsRequired(), moveOrder.timeRequired(),
				moveOrder.loadSubUnits(), moveOrder.orderDelayRemaining()
		);

		saveFromQuery(query);
	}


}
