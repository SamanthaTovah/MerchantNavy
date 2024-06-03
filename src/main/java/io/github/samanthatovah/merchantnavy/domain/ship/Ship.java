package io.github.samanthatovah.merchantnavy.domain.ship;

public record Ship(
		int id,
		String name,
		int gameId,
		int fleetId,
		int raceId,
		int shipClassId,
		float fuel
) {
}
