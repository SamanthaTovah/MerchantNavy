package io.github.samanthatovah.merchantnavy.domain.moveorder;

public record MoveOrder(
		Integer id, // null only to put in DataBase (autoincrement)
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
		double maxItems,
		int newSystemId,
		int newWarpPointId,
		String description,
		String messageText,
		float minQuantity,
		int orderDelay,
		int orbDistance,
		double minDistance,
		int arrived,
		double surveyPointsRequired,
		int timeRequired,
		int loadSubUnits,
		int orderDelayRemaining,
		int destinationId
) {
}
