package io.github.samanthatovah.merchantnavy.domain.population;

public record Population(
		int id,
		int gameId,
		int raceId,
		int speciesId,
		int systemId,
		int systemBodyId,
		String name,
		ColonistDestination colonistDestination,
		float unrestPoints
) {
	enum ColonistDestination {
		DESTINATION, SOURCE, STABLE;

		static ColonistDestination fromInt(int intRaw) {
			return switch (intRaw) {
				case 0 -> DESTINATION;
				case 1 -> SOURCE;
				case 2 -> STABLE;
				default -> throw new IllegalStateException("Unexpected value: " + intRaw);
			};
		}
	}
}
