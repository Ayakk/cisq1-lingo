package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    static Stream<Arguments> provideAttemptsForGameStatus() {
        return Stream.of(
                Arguments.of("woord", GameStatus.STOPPED),
                Arguments.of("woard", GameStatus.STOPPED)
        );
    }


    @ParameterizedTest
    @MethodSource("provideAttemptsForGameStatus")
    @DisplayName("Check game status with various attempts")
    void checkGameStatus(String attempt, GameStatus gameStatus){
        Feedback f = new Feedback();
        Round r = new Round(f);
        r.startRound(attempt);
        assertEquals(r.getGameStatus(), gameStatus);
    }

//    @Test
//    @DisplayName("Test if the status boolean is false before a round starts")
//    void checkRoundStatus(){
//        Round r = new Round();
//        assertFalse(r.getRoundStatus());
//    }
//
//    @Test
//    @DisplayName("Check if round plays correctly")
//    void checkIfRoundPlaysCorrectly(){
//        Round r = new Round();
//        Feedback feedback = new Feedback();
//        feedback.setAttempt("woard");
//        r.setF(feedback);
//        r.startRound();
//        assertTrue(r.getRoundStatus());
//    }
//
//    @Test
//    void testStartRonde(){
//        Round round = new Round();
//        round.startRound("woord");
//    }
}