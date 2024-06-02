package io.github.samanthatovah.merchantnavy.database;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
@Configuration
public class DatabaseConfig {

	@Bean
	public Connection connection(@Value("${aurora.dburl}") String dbUrl) {
		try {
			log.info("Connection to database has been established.");
			return DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
}
