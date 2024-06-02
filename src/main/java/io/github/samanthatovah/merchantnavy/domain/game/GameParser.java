package io.github.samanthatovah.merchantnavy.domain.game;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameParser implements ResultSetParser<Game> {

	@Override
	public List<Game> parse(ResultSet resultSet) throws SQLException {
		List<Game> games = new ArrayList<>();
		while (resultSet.next()) {
			Game game = new Game(
					resultSet.getInt("GameId"),
					resultSet.getString("GameName")
			);
			games.add(game);
		}
		return games;
	}
}
