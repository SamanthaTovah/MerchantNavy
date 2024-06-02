package io.github.samanthatovah.merchantnavy.domain.game;

import io.github.samanthatovah.merchantnavy.common.Repository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameRepository extends Repository<Game> {

	public GameRepository(DatabaseService databaseService, GameParser parser) {
		super(databaseService, parser);
	}

	public List<Game> getAll() {
		String query = "SELECT * FROM FCT_Game;";
		return getAllFromQuery(query);
	}
}
