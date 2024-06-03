package io.github.samanthatovah.merchantnavy.common;

import io.github.samanthatovah.merchantnavy.database.DatabaseException;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericRepository<T> {

	/*
	default values are for integration tests only
	 */
	public static int GAME_ID = 114;
	public static int RACE_ID = 584;

	private final DatabaseService databaseService;
	private final ResultSetParser<T> parser;

	public GenericRepository(DatabaseService databaseService, ResultSetParser<T> parser) {
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
