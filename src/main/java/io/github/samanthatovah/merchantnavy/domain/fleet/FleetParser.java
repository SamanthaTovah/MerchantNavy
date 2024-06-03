package io.github.samanthatovah.merchantnavy.domain.fleet;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FleetParser implements ResultSetParser<Fleet> {

	@Override
	public List<Fleet> parse(ResultSet resultSet) throws SQLException {
		List<Fleet> fleets = new ArrayList<>();
		while (resultSet.next()) {
			Fleet fleet = new Fleet(
					resultSet.getInt("FleetID"),
					resultSet.getInt("GameID"),
					resultSet.getInt("RaceID"),
					resultSet.getInt("SystemID"),
					resultSet.getInt("OrbitBodyID"),
					resultSet.getString("FleetName"),
					resultSet.getFloat("OrbitDistance"),
					resultSet.getFloat("Xcor"),
					resultSet.getFloat("Ycor")
			);
			fleets.add(fleet);
		}
		return fleets;
	}
}
