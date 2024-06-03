package io.github.samanthatovah.merchantnavy.domain.jumppoint;

import io.github.samanthatovah.merchantnavy.common.GenericRepository;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JumpPointRepository extends GenericRepository<JumpPoint> {

	public JumpPointRepository(DatabaseService databaseService, JumpPointParser parser) {
		super(databaseService, parser);
	}

	public List<JumpPoint> getAll() {
		String query = "SELECT * FROM FCT_JumpPoint WHERE GameID = %d;"
				.formatted(GAME_ID);
		return getAllFromQuery(query);
	}

	public JumpPoint get(int id) {
		String query = "SELECT * FROM FCT_JumpPoint WHERE GameID = %d AND WarpPointID = %d;"
				.formatted(GAME_ID, id);
		return getOneFromQuery(query);
	}
}
