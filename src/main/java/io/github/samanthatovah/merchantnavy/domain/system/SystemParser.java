package io.github.samanthatovah.merchantnavy.domain.system;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemParser implements ResultSetParser<System> {

	@Override
	public List<System> parse(ResultSet resultSet) throws SQLException {
		List<System> systems = new ArrayList<>();
		while (resultSet.next()) {
			System system = new System(
					resultSet.getInt("SystemID"),
					resultSet.getInt("SystemNumber"),
					resultSet.getInt("Stars"),
					resultSet.getInt("GameID"),
					resultSet.getBoolean("SolSystem")
			);
			systems.add(system);
		}
		return systems;
	}
}
