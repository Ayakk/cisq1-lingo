package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.CiTestConfiguration;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Import(CiTestConfiguration.class)
public class ServiceIntegrationTest {
    @Autowired
    private TrainerService trainerService;

    @Test
    @DisplayName("Testing guessing words using the service")
    void guessingWordTest() throws Exception{
        trainerService.startNewGame();
        trainerService.startNewRound();
        assertEquals(trainerService.guess("waord"), "W.ORD");
    }

    @Test
    @DisplayName("Testing finding game from db")
    void findGame() throws Exception{
        Optional<Game> g = trainerService.findgame(1);
        assertTrue(g.isPresent());
    }

    @Test
    @DisplayName("Testing finding game from db")
    void saveGame() throws Exception{
        trainerService.startNewGame();
        trainerService.startNewRound();
        trainerService.guess("woord");
        assertTrue(trainerService.saveGame());
    }
}
//todo return marklist + feedbacklist + guess