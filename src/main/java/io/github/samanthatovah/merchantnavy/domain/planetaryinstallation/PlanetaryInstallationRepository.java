package io.github.samanthatovah.merchantnavy.domain.planetaryinstallation;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetaryInstallationRepository extends GenericRepository<PlanetaryInstallation> {

	public PlanetaryInstallationRepository(DatabaseService databaseService, PlanetaryInstallationParser parser) {
		super(databaseService, parser);
	}

	public List<PlanetaryInstallation> getAll() {
		String query = "SELECT * FROM DIM_PlanetaryInstallation;";
		return getAllFromQuery(query);
	}

	public PlanetaryInstallation get(int id) {
		String query = "SELECT * FROM DIM_PlanetaryInstallation WHERE PlanetaryInstallationID = %d;"
				.formatted(id);
		return getOneFromQuery(query);
	}

	public PlanetaryInstallation getByName(String name) {
		String query = "SELECT * FROM DIM_PlanetaryInstallation WHERE AND Name = %s;"
				.formatted(name);
		return getOneFromQuery(query);
	}
}
