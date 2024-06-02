package io.github.samanthatovah.merchantnavy.domain.population;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PopulationParser implements ResultSetParser<Population> {

	@Override
	public List<Population> parse(ResultSet resultSet) throws SQLException {
		List<Population> populations = new ArrayList<>();
		while (resultSet.next()) {
			Population population = new Population(
					resultSet.getInt("PopulationID"),
					resultSet.getInt("GameID"),
					resultSet.getInt("RaceID"),
					resultSet.getInt("SpeciesID"),
					resultSet.getInt("SystemID"),
					resultSet.getInt("SystemBodyID"),
					resultSet.getString("PopName"),
					Population.PopulationDestination.fromInt(resultSet.getInt("ColonistDestination")),
					resultSet.getFloat("UnrestPoints")
			);
			populations.add(population);
		}
		return populations;
	}
}
