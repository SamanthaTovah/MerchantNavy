package io.github.samanthatovah.merchantnavy.domain.game;

import io.github.samanthatovah.merchantnavy.common.Repository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameRepository extends Repository<Game> {

	public GameRepository(DatabaseService databaseService, GameParser gameParser) {
		super(databaseService, gameParser);
	}

	public List<Game> getAll() {
		String query = "SELECT * FROM FCT_Game;";
		return getAll(query);
	}
}
