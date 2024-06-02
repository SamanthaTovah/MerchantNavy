package io.github.samanthatovah.merchantnavy.database;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
@RequiredArgsConstructor
@Service
public class DatabaseService {

	private final Connection connection;

	public ResultSet executeQuery(String query) {
		try {
			Statement statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

	public void close() {
		try {
			if (connection != null) {
				connection.close();
				log.info("Connection to database has been closed.");
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
}
