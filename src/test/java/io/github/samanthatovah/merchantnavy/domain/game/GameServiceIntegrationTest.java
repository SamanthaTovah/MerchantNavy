package io.github.samanthatovah.merchantnavy.domain.game;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class GameServiceIntegrationTest {

	@Autowired
	private GameService gameService;

	@Test
	public void getGame() {
		Game game = gameService.getGame();

		log.info(game.id());
		log.info(game.name());
	}
}
