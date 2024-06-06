package io.github.samanthatovah.merchantnavy.domain.moveorder;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoveOrderParser implements ResultSetParser<MoveOrder> {

	@Override
	public List<MoveOrder> parse(ResultSet resultSet) throws SQLException {
		List<MoveOrder> moveOrders = new ArrayList<>();
		while (resultSet.next()) {
			MoveOrder moveOrder = new MoveOrder(
					resultSet.getInt("MoveOrderID"),
					resultSet.getInt("GameID"),
					resultSet.getInt("RaceID"),
					resultSet.getInt("FleetID"),
					resultSet.getInt("MoveActionID"),
					resultSet.getInt("MoveOrder"),
					resultSet.getInt("StartSystemID"),
					resultSet.getInt("DestinationType"),
					resultSet.getInt("PopulationID"),
					resultSet.getInt("DestinationItemType"),
					resultSet.getInt("DestinationItemID"),
					resultSet.getFloat("MaxItems"),
					resultSet.getInt("NewSystemID"),
					resultSet.getInt("NewWarpPointID"),
					resultSet.getString("Description"),
					resultSet.getString("MessageText"),
					resultSet.getFloat("MinQuantity"),
					resultSet.getInt("OrderDelay"),
					resultSet.getInt("OrbDistance"),
					resultSet.getDouble("MinDistance"),
					resultSet.getInt("Arrived"),
					resultSet.getInt("SurveyPointsRequired"),
					resultSet.getInt("TimeRequired"),
					resultSet.getInt("LoadSubUnits"),
					resultSet.getInt("OrderDelayRemaining")
			);
			moveOrders.add(moveOrder);
		}
		return moveOrders;
	}
}
