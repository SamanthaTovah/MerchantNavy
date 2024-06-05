package io.github.samanthatovah.merchantnavy.domain.systembody;

public record SystemBody(
		int id,
		int systemId,
		int starId,
		int gameId,
		String name,
		int planetNumber,
		int orbitNumber,
		float orbitalDistance,
		float bearing,
		int parentBodyId,
		float xCor,
		float yCor
) {
}
