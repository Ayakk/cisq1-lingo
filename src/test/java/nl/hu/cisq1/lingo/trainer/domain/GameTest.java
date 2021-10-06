package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    @DisplayName("checking game status at the end of a game")
    void checkGameStatusStopped(){
        Feedback f = new Feedback();
        Word w = new Word();
        Round r = new Round(f, w);

        Game g = new Game(r, w);
        g.startGame("woard");
        assertEquals(g.getGameStatus(), GameStatus.STOPPED);
    }
}