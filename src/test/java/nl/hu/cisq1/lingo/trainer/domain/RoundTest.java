package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    @DisplayName("Test if a word is assigned when a new round starts")
    void checkWordAssigned(){
        Round r = new Round();
        assertEquals("woordje", r.getW().getToGuessWord());
    }

    @Test
    @DisplayName("Test if the status boolean is changed when a new round starts")
    void checkIfRoundHasStarted(){
        Round r = new Round();
        r.startRound();
        assertTrue(r.getRoundStatus());
    }

    @Test
    @DisplayName("Check if round plays correctly")
    void checkIfRoundPlaysCorrectly(){
        Round r = new Round();
        r.startRound();
    }

}