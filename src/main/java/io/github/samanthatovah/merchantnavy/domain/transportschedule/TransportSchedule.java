package io.github.samanthatovah.merchantnavy.domain.transportschedule;

import io.github.samanthatovah.merchantnavy.domain.fleet.Fleet;
import io.github.samanthatovah.merchantnavy.domain.planetaryinstallation.PlanetaryInstallation;

public record TransportSchedule(
		PlanetaryInstallation cargo,
		float cargoAmount,
		int exportSystemId,
		int importSystemId,
		Fleet fleet
) {
}
