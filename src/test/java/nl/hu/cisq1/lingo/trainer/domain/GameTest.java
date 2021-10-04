package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("check if game starts correctly")
    void startGame(){
        Feedback f = new Feedback();
        Round r = new Round(f);
        Word w = new Word();

        Game g = new Game(r, w);
        g.startGame();
    }

//    @Test
//    @DisplayName("Check if game plays round")
//    void playGame(){
//        Game g = new Game();
////        g.startGame();
//
//    }

}