package io.github.samanthatovah.merchantnavy.domain.shipclass;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShipClassParser implements ResultSetParser<ShipClass> {

	@Override
	public List<ShipClass> parse(ResultSet resultSet) throws SQLException {
		List<ShipClass> shipClasses = new ArrayList<>();
		while (resultSet.next()) {
			ShipClass shipClass = new ShipClass(
					resultSet.getInt("ShipClassID"),
					resultSet.getString("ClassName"),
					resultSet.getInt("GameID"),
					resultSet.getInt("RaceID"),
					resultSet.getInt("CargoCapacity"),
					resultSet.getInt("ColonistCapacity"),
					resultSet.getInt("FuelCapacity"),
					resultSet.getFloat("MagazineCapacity"),
					resultSet.getInt("MaxSpeed"),
					resultSet.getInt("EnginePower"),
					resultSet.getFloat("FuelEfficiency"),
					resultSet.getInt("MainFunction")

			);
			shipClasses.add(shipClass);
		}
		return shipClasses;
	}
}
