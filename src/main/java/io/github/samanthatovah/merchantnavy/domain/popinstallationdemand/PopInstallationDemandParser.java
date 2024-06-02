package io.github.samanthatovah.merchantnavy.domain.popinstallationdemand;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PopInstallationDemandParser implements ResultSetParser<PopInstallationDemand> {

	@Override
	public List<PopInstallationDemand> parse(ResultSet resultSet) throws SQLException {
		List<PopInstallationDemand> popInstallationDemands = new ArrayList<>();
		while (resultSet.next()) {
			PopInstallationDemand popInstallationDemand = new PopInstallationDemand(
					resultSet.getInt("PopulationId"),
					resultSet.getInt("InstallationId"),
					resultSet.getInt("GameId"),
					resultSet.getFloat("Amount"),
					resultSet.getBoolean("Export"),
					resultSet.getBoolean("NonEssential")
			);
			popInstallationDemands.add(popInstallationDemand);
		}
		return popInstallationDemands;
	}
}
