package io.github.samanthatovah.merchantnavy.domain.shipclass;

public record ShipClass(
		int id,
		String name,
		int gameId,
		int raceId,
		int cargoCapacity,
		int colonistCapacity,
		int fuelCapacity,
		float magazineCapacity,
		int maxSpeed,
		int enginePower,
		float fuelEfficiency,
		int mainFunction // not sure yet how to map this to anything of meaning
) {
}
