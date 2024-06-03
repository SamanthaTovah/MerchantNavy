package io.github.samanthatovah.merchantnavy.domain.jumppoint;

public record JumpPoint(
		int id,
		int gameId,
		int systemId,
		float distance,
		float bearing,
		int wpLink, // not sure what this is
		float xCor,
		float yCor,
		int jumpGateStrength, // not sure how to map this yet
		int jumpGateRaceID
) {
}
