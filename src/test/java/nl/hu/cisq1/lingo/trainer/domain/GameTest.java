package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    @DisplayName("checking game status at the end of a game")
    void checkGameStatusStopped(){
        Feedback f = new Feedback();
        Round r = new Round(f);

        Game g = new Game(r);
        g.startGame("woord");
        assertEquals(g.getGameStatus(), GameStatus.STOPPED);
    }

    @Test
    @DisplayName("checking if score is calculated correctly")
    void checkGameScore(){
        Feedback f = new Feedback();
        Round r = new Round(f);

        Game g = new Game(r);
        g.startGame("waord");
        g.startGame("woord");
        assertEquals(g.getScore(), 30);
    }
}

