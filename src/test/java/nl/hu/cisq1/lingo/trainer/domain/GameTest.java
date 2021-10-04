package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("check if game starts correctly")
    void startGame(){
        Game g = new Game();
        g.startGame();
        assertTrue(g.getStatus());
    }

    @Test
    @DisplayName("Check if game plays round")
    void playGame(){
        Game g = new Game();
        g.startGame();
    }
}