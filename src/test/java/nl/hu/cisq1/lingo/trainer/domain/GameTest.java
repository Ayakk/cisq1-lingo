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
}

