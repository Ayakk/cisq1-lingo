package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    static Stream<Arguments> provideAttemptsForPointsReturned() {
        return Stream.of(
                Arguments.of("woord", 30),
                Arguments.of("woard", 0)
        );
    }


    @ParameterizedTest
    @MethodSource("provideAttemptsForPointsReturned")
    @DisplayName("Check points returned with various attempts")
    void checkPointsReturned(String attempt, int pointsReturned){
        Round r = new Round();
        r.setWordToGuess("woord");
        r.newPlayRound(attempt);
        assertEquals(r.getScore(), pointsReturned);
    }

    @Test
    @DisplayName("check if boolean value corresponds with gamestatus")
    void isGameStoppedTestWhenGuessIsCorrect(){
        Round r = new Round();
        r.setWordToGuess("woord");
        r.newPlayRound("woord");
        assertTrue(r.isGameStopped());
    }

    @Test
    @DisplayName("check if boolean value corresponds with gamestatus")
    void isGameNotStoppedWhileNotGuessing(){
        Round r = new Round();
        r.newPlayRound("perup");
        assertFalse(r.isGameStopped());
    }

    @Test
    @DisplayName("check if game is stopped if status is changed")
    void isGameStoppedIfStatusIsChanged(){
        Round r = new Round();
        r.setGameStatus(GameStatus.STOPPED);
        assertTrue(r.isGameStopped());
    }

    @Test
    @DisplayName("check if game is stopped if status is changed and too many attempts were made")
    void isGameStoppedIfStatusIsChangedAndTooManyAttempts(){
        Round r = new Round();
        r.setAttempts(5);
        r.setGameStatus(GameStatus.PLAYING);
        assertFalse(r.checkIfGameContinues());
    }

    @Test
    @DisplayName("check if game is stopped after too many attempts")
    void isGameStoppedAfterTooManyAttempts(){
        Round r = new Round();
        r.setAttempts(5);
        r.setGameStatus(GameStatus.STOPPED);
        assertFalse(r.checkIfGameContinues());
    }

    @Test
    @DisplayName("check if boolean attempt method returns true if attempts are below 4")
    void checkAttemptsMethodBelow4(){
        Round r = new Round();
        r.setAttempts(3);
        assertTrue(r.checkIfGameContinues());
    }

    @Test
    @DisplayName("check if boolean attempt method returns true if attempts are above 4")
    void checkAttemptsMethodOver4(){
        Round r = new Round();
        r.setAttempts(5);
        assertFalse(r.checkIfGameContinues());
    }

    @Test
    @DisplayName("check if the else statement in the method returns the correct value")
    void checkElseInNewPlayRound(){
        Round r = new Round();
        r.setWordToGuess("appel");
        r.setAttempts(6);
        assertEquals("Verloren! U heeft 0 punten verdient!", r.newPlayRound("appel"));
    }
}