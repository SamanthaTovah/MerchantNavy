package io.github.samanthatovah.merchantnavy.domain.jumppoint;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JumpPointParser implements ResultSetParser<JumpPoint> {

	@Override
	public List<JumpPoint> parse(ResultSet resultSet) throws SQLException {
		List<JumpPoint> jumpPoints = new ArrayList<>();
		while (resultSet.next()) {
			JumpPoint jumpPoint = new JumpPoint(
					resultSet.getInt("WarpPointID"),
					resultSet.getInt("GameID"),
					resultSet.getInt("SystemID"),
					resultSet.getFloat("Distance"),
					resultSet.getFloat("Bearing"),
					resultSet.getInt("WPLink"),
					resultSet.getFloat("Xcor"),
					resultSet.getFloat("Ycor"),
					resultSet.getInt("JumpGateStrength"),
					resultSet.getInt("JumpGateRaceID")
			);
			jumpPoints.add(jumpPoint);
		}
		return jumpPoints;
	}
}
