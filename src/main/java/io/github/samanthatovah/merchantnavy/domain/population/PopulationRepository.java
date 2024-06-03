package io.github.samanthatovah.merchantnavy.domain.population;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationRepository extends GenericRepository<Population> {

	public PopulationRepository(DatabaseService databaseService, PopulationParser parser) {
		super(databaseService, parser);
	}

	public List<Population> getAll() {
		String query = "SELECT * FROM FCT_Population WHERE GameID = " + GAME_ID + ";";
		return getAllFromQuery(query);
	}

	public Population get(int id) {
		String query = "SELECT * FROM FCT_Population WHERE GameID = " + GAME_ID + " AND PopulationID = " + id + ";";
		return getOneFromQuery(query);
	}
}
