package io.github.samanthatovah.merchantnavy.domain.game;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class GameService {

	private final GameRepository gameRepository;

	public Game getGame() {
		List<Game> games = gameRepository.getAll();
		if (games.size() != 1) {
			throw new IllegalStateException("Cannot handle " + games.size() + " games, must be 1");
		}
		return games.get(0);
	}
}
