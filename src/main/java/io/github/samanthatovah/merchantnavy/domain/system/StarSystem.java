package io.github.samanthatovah.merchantnavy.domain.system;

public record StarSystem(
		int id,
		int systemNumber,
		int stars,
		int gameId,
		boolean solSystem
) {
}
