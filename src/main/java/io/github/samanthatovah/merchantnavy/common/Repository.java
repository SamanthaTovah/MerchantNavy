package io.github.samanthatovah.merchantnavy.common;

import io.github.samanthatovah.merchantnavy.database.DatabaseException;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.beans.factory.annotation.Value;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class Repository<T> {

	private final DatabaseService databaseService;
	private final ResultSetParser<T> parser;

	@Value("${aurora.gameid}")
	protected int gameId;

	public Repository(DatabaseService databaseService, ResultSetParser<T> parser) {
		this.databaseService = databaseService;
		this.parser = parser;
	}

	protected List<T> getAllFromQuery(String query) {
		try (ResultSet resultSet = databaseService.executeQuery(query)) {
			return parser.parse(resultSet);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

	protected T getOneFromQuery(String query) {
		List<T> list = getAllFromQuery(query);
		if (list.size() != 1) {
			throw new IllegalStateException("Expected 1 from query (" + query + "), got " + list.size());
		}
		return list.get(0);
	}

}
