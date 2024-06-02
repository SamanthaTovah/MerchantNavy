package io.github.samanthatovah.merchantnavy.domain.planetaryinstallation;

import io.github.samanthatovah.merchantnavy.common.ResultSetParser;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetaryInstallationParser implements ResultSetParser<PlanetaryInstallation> {

	@Override
	public List<PlanetaryInstallation> parse(ResultSet resultSet) throws SQLException {
		List<PlanetaryInstallation> planetaryInstallations = new ArrayList<>();
		while (resultSet.next()) {
			PlanetaryInstallation planetaryInstallation = new PlanetaryInstallation(
					resultSet.getInt("PlanetaryInstallationID"),
					resultSet.getString("Name"),
					resultSet.getInt("CargoPoints")
			);
			planetaryInstallations.add(planetaryInstallation);
		}
		return planetaryInstallations;
	}
}
