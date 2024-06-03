package io.github.samanthatovah.merchantnavy.domain.popinstallationdemand;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopInstallationDemandRepository extends GenericRepository<PopInstallationDemand> {

	public PopInstallationDemandRepository(DatabaseService databaseService, PopInstallationDemandParser parser) {
		super(databaseService, parser);
	}

	public List<PopInstallationDemand> getAll() {
		String query = "SELECT * FROM FCT_PopInstallationDemand WHERE GameID = " + GAME_ID + ";";
		return getAllFromQuery(query);
	}
}
