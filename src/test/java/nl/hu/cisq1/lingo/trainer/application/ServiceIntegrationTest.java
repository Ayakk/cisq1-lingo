package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.CiTestConfiguration;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.words.application.WordService;
import nl.hu.cisq1.lingo.words.domain.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
@Import(CiTestConfiguration.class)
public class ServiceIntegrationTest {
    @Autowired
    private TrainerService trainerService;

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
        trainerService.guess("woord");
        assertTrue(trainerService.saveGame());
    }
}
