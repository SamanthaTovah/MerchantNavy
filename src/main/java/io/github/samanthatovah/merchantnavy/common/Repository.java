package io.github.samanthatovah.merchantnavy.common;

import io.github.samanthatovah.merchantnavy.database.DatabaseException;
import io.github.samanthatovah.merchantnavy.database.DatabaseService;
import org.springframework.beans.factory.annotation.Value;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class Repository<T> {

	private final DatabaseService databaseService;
	private final ResultSetParser<T> resultSetParser;

	@Value("${aurora.gameid}")
	protected int gameId;

	public Repository(DatabaseService databaseService, ResultSetParser<T> resultSetParser) {
		this.databaseService = databaseService;
		this.resultSetParser = resultSetParser;
	}

	protected List<T> getAll(String query) {
		try (ResultSet resultSet = databaseService.executeQuery(query)) {
			return resultSetParser.parse(resultSet);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

}
