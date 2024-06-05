package io.github.samanthatovah.merchantnavy.domain.systembody;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemBodyParser implements ResultSetParser<SystemBody> {

	@Override
	public List<SystemBody> parse(ResultSet resultSet) throws SQLException {
		List<SystemBody> systemBodies = new ArrayList<>();
		while (resultSet.next()) {
			SystemBody systemBody = new SystemBody(
					resultSet.getInt("SystemBodyID"),
					resultSet.getInt("SystemID"),
					resultSet.getInt("StarID"),
					resultSet.getInt("GameID"),
					resultSet.getString("Name"),
					resultSet.getInt("PlanetNumber"),
					resultSet.getInt("OrbitNumber"),
					resultSet.getFloat("OrbitalDistance"),
					resultSet.getFloat("Bearing"),
					resultSet.getInt("ParentBodyID"),
					resultSet.getFloat("Xcor"),
					resultSet.getFloat("Ycor")
			);
			systemBodies.add(systemBody);
		}
		return systemBodies;
	}
}
