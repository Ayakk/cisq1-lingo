package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameTest {

    @Test
    @DisplayName("checking game status at the end of a round")
    void checkGameStatusStopped(){
        Game g = new Game("woord");
        Round r = new Round();
        g.startGame("woord", r);
        assertEquals(g.getGameStatus(), GameStatus.STOPPED);
    }

    @Test
    @DisplayName("checking game status at the start of a round")
    void checkGameStatusPlaying(){
        Round r = new Round();
        assertEquals(r.getGameStatus(), GameStatus.PLAYING);
    }

    @Test
    @DisplayName("checking if score is calculated correctly")
    void checkGameScore(){
        Round r = new Round();
        r.setWordToGuess("appel");
        r.newPlayRound("appel");
        assertEquals(r.getScore(), 30);
    }

    @Test
    @DisplayName("checking if getter returns correct value")
    void testGetNrCorrect(){
        Game g = new Game();
        assertEquals(g.getNrCorrect(), 5);
    }

    @Test
    @DisplayName("checking if setter returns correct value")
    void testSetNrCorrect(){
        Game g = new Game();
        g.setNrCorrect(10);
        assertEquals(g.getNrCorrect(), 10);
    }

    @Test
    @DisplayName("checking if setter returns correct value")
    void testSetWordToGuess(){
        Game g = new Game();
        g.setWordToGuess("taart");
        assertEquals(g.getWordToGuess(), "taart");
    }

    @Test
    @DisplayName("checking if reset returns correct values")
    void testGameResetFNextRound(){
        Game g = new Game();
        Round r = new Round();
        g.setRound(r);
        g.gameResetFNextRound();
        assertEquals(g.getScore(), 0);
    }
}

