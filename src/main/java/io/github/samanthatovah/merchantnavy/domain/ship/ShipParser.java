package io.github.samanthatovah.merchantnavy.domain.ship;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShipParser implements ResultSetParser<Ship> {

	@Override
	public List<Ship> parse(ResultSet resultSet) throws SQLException {
		List<Ship> ships = new ArrayList<>();
		while (resultSet.next()) {
			Ship ship = new Ship(
					resultSet.getInt("ShipID"),
					resultSet.getString("ShipName"),
					resultSet.getInt("GameID"),
					resultSet.getInt("FleetID"),
					resultSet.getInt("RaceID"),
					resultSet.getInt("ShipClassID"),
					resultSet.getFloat("Fuel")
			);
			ships.add(ship);
		}
		return ships;
	}
}
