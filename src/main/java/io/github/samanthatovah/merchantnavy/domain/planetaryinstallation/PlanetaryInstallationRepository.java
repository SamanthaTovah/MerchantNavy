package io.github.samanthatovah.merchantnavy.domain.planetaryinstallation;

import io.github.samanthatovah.merchantnavy.common.Repository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetaryInstallationRepository extends Repository<PlanetaryInstallation> {

	public PlanetaryInstallationRepository(DatabaseService databaseService, PlanetaryInstallationParser parser) {
		super(databaseService, parser);
	}

	public List<PlanetaryInstallation> getAll() {
		String query = "SELECT * FROM DIM_PlanetaryInstallation;";
		return getAllFromQuery(query);
	}

	public PlanetaryInstallation get(int id) {
		String query = "SELECT * FROM DIM_PlanetaryInstallation WHERE PlanetaryInstallationID = " + id + ";";
		return getOneFromQuery(query);
	}
}
