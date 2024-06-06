package io.github.samanthatovah.merchantnavy.domain.transportschedule;

import io.github.samanthatovah.merchantnavy.domain.fleet.Fleet;
import io.github.samanthatovah.merchantnavy.domain.planetaryinstallation.PlanetaryInstallation;
import io.github.samanthatovah.merchantnavy.domain.population.Population;

public record TransportSchedule(
		PlanetaryInstallation cargo,
		double cargoAmount,
		Population exportPopulation,
		Population importPopulation,
		Fleet fleet
) {
}
