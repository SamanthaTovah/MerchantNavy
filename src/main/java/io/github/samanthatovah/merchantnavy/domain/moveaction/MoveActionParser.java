package io.github.samanthatovah.merchantnavy.domain.moveaction;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoveActionParser implements ResultSetParser<MoveAction> {

	@Override
	public List<MoveAction> parse(ResultSet resultSet) throws SQLException {
		List<MoveAction> moveActions = new ArrayList<>();
		while (resultSet.next()) {
			MoveAction moveAction = new MoveAction(
					resultSet.getInt("MoveActionID"),
					resultSet.getString("Description")
			);
			moveActions.add(moveAction);
		}
		return moveActions;
	}
}
