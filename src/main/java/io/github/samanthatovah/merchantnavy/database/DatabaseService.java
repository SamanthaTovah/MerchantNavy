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

	public int executeUpdate(String query, boolean returnGeneratedKeys) {
		log.info("query made is: {}", query);
		try (Statement statement = connection.createStatement()) {
			if (returnGeneratedKeys) {
				statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				try (ResultSet rs = statement.getGeneratedKeys()) {
					if (rs.next()) {
						return rs.getInt(1); // Assuming a single generated key
					}
				}
			} else {
				return statement.executeUpdate(query);
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		return -1; // Return -1 if no keys were generated
	}

}
