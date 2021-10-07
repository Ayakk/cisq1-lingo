package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
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
        Feedback f = new Feedback();
        Round r = new Round(f);
        assertEquals(r.startRound(attempt), pointsReturned);
    }

}