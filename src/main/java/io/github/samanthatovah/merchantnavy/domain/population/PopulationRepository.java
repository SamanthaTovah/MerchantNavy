package io.github.samanthatovah.merchantnavy.domain.population;

import io.github.samanthatovah.merchantnavy.common.Repository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationRepository extends Repository<Population> {

	public PopulationRepository(DatabaseService databaseService, PopulationParser parser) {
		super(databaseService, parser);
	}

	public List<Population> getAll() {
		String query = "SELECT * FROM FCT_Population WHERE GameID = " + gameId + ";";
		return getAllFromQuery(query);
	}

	public Population get(int id) {
		String query = "SELECT * FROM FCT_Population WHERE GameID = " + gameId + " AND PopulationID = " + id + ";";
		return getOneFromQuery(query);
	}
}
