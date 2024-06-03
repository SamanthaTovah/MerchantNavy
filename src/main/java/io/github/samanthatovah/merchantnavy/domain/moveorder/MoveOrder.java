package io.github.samanthatovah.merchantnavy.domain.moveorder;

public record MoveOrder(
		int id,
		int gameId,
		int raceId,
		int fleetId,
		int moveActionId,
		int moveOrder,
		int startSystemId,
		int destinationType,
		int populationId,
		int destinationItemType,
		int destinationItemId,
		float maxItems,
		int newSystemId,
		int newWarpPointId,
		String description,
		String messageText,
		float minQuantity
) {
}
