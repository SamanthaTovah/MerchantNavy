package io.github.samanthatovah.merchantnavy.domain.shipcargo;

public record ShipCargo(
		int id,
		int shipId,
		int cargoTypeId,
		int cargoId,
		float amount,
		int speciesId,
		int startingPop,
		boolean neutral // could be int-map instead of boolean
) {
}
