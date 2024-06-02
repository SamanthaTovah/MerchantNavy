package io.github.samanthatovah.merchantnavy.domain.popinstallationdemand;

public record PopInstallationDemand(
		int populationId,
		int installationId,
		int gameId,
		float amount,
		boolean export,
		boolean nonEssential // not sure what this is
) {
}
