package io.github.samanthatovah.merchantnavy.domain.fleet;

public record Fleet(
		int id,
		int gameId,
		int raceId,
		int systemId,
		int orbitBodyId,
		String name,
		float orbitDistance,
		float xCor,
		float yCor
) {
}
