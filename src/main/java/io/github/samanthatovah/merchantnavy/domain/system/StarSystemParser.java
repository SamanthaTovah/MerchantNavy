package io.github.samanthatovah.merchantnavy.domain.system;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StarSystemParser implements ResultSetParser<StarSystem> {

	@Override
	public List<StarSystem> parse(ResultSet resultSet) throws SQLException {
		List<StarSystem> starSystems = new ArrayList<>();
		while (resultSet.next()) {
			StarSystem starSystem = new StarSystem(
					resultSet.getInt("SystemID"),
					resultSet.getInt("SystemNumber"),
					resultSet.getInt("Stars"),
					resultSet.getInt("GameID"),
					resultSet.getBoolean("SolSystem")
			);
			starSystems.add(starSystem);
		}
		return starSystems;
	}
}
