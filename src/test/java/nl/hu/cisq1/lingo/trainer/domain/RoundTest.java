package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.BeforeAll;
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
    @DisplayName("Test if the status boolean is false before a round starts")
    void checkRoundStatus(){
        Round r = new Round();
        assertFalse(r.getRoundStatus());
    }

    @Test
    @DisplayName("Check if round plays correctly")
    void checkIfRoundPlaysCorrectly(){
        Round r = new Round();
        Feedback feedback = new Feedback();
        feedback.setAttempt("woard");
        r.setF(feedback);
        r.startRound();
        assertTrue(r.getRoundStatus());
    }

    @Test
    void testStartRonde(){
        Round round = new Round();
        round.startRound("woord");
    }
}