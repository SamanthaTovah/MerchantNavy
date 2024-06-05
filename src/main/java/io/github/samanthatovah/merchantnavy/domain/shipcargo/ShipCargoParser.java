package io.github.samanthatovah.merchantnavy.domain.shipcargo;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShipCargoParser implements ResultSetParser<ShipCargo> {

	@Override
	public List<ShipCargo> parse(ResultSet resultSet) throws SQLException {
		List<ShipCargo> shipCargos = new ArrayList<>();
		while (resultSet.next()) {
			ShipCargo shipCargo = new ShipCargo(
					resultSet.getInt("GameID"),
					resultSet.getInt("ShipID"),
					resultSet.getInt("CargoTypeID"),
					resultSet.getInt("CargoID"),
					resultSet.getFloat("Amount"),
					resultSet.getInt("SpeciesID"),
					resultSet.getInt("StartingPop"),
					resultSet.getBoolean("Neutral")
			);
			shipCargos.add(shipCargo);
		}
		return shipCargos;
	}
}
