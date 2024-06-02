package io.github.samanthatovah.merchantnavy.domain.race;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaceParser implements ResultSetParser<Race> {

	@Override
	public List<Race> parse(ResultSet resultSet) throws SQLException {
		List<Race> races = new ArrayList<>();
		while (resultSet.next()) {
			Race race = new Race(
					resultSet.getInt("RaceId"),
					resultSet.getInt("GameId"),
					resultSet.getBoolean("NPR"),
					resultSet.getString("RaceTitle")
			);
			races.add(race);
		}
		return races;
	}
}
