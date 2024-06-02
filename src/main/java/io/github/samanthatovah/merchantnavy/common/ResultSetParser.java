package io.github.samanthatovah.merchantnavy.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetParser<T> {

	List<T> parse(ResultSet resultSet) throws SQLException;
}
