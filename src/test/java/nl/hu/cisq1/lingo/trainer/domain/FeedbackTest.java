package nl.hu.cisq1.lingo.trainer.domain;

import com.sun.xml.bind.v2.TODO;
import net.bytebuddy.pool.TypePool;
import nl.hu.cisq1.lingo.words.domain.exception.InvalidFeedbackException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {
    @Test
    @DisplayName("Word is guessed if all letters are correct")
    void wordIsGuessed(){
        Feedback f = new Feedback("woord", List.of(Mark.status.CORRECT, Mark.status.CORRECT, Mark.status.CORRECT, Mark.status.CORRECT, Mark.status.CORRECT));
        assertTrue(f.isWordGuessed(f));
    }

    @Test
    @DisplayName("Word is not guessed if some or all letters are incorrect")
    void wordIsNotGuessed(){
        Feedback f = new Feedback("woord", List.of(Mark.status.INVALID, Mark.status.CORRECT, Mark.status.CORRECT, Mark.status.CORRECT, Mark.status.CORRECT));
        assertFalse(f.isWordGuessed(f));
    }


    @Test
    @DisplayName("given word is invalid")
    void guessIsInvalid(){
        Feedback f = new Feedback("hek", List.of(Mark.status.INVALID, Mark.status.INVALID, Mark.status.INVALID, Mark.status.INVALID, Mark.status.INVALID));
        assertTrue(f.wordIsInvalid(f));
    }

    @Test
    @DisplayName("given word is not invalid")
    void guessValid(){
        Feedback f = new Feedback("woord", List.of(Mark.status.CORRECT, Mark.status.CORRECT, Mark.status.CORRECT, Mark.status.CORRECT, Mark.status.CORRECT));
        assertFalse(f.wordIsInvalid(f));
    }

//    @Test
//    @DisplayName("Test Invalid Feedback length")
//    void InvalidFeedbackExceptionCheck(){
//        assertThrows(InvalidFeedbackException.class, () -> new Feedback("woord", List.of(Mark.status.CORRECT)));
//    }

    @Test
    @DisplayName("Give hint")
    void giveHintTest(){
        Feedback f = new Feedback("waara", List.of(Mark.status.CORRECT, Mark.status.ABSENT, Mark.status.ABSENT, Mark.status.CORRECT, Mark.status.ABSENT));
        assertEquals("W..R.", f.giveBetterHint());
    }

    @Test
    @DisplayName("Give hint")
    void giveBetterHintTest(){
        Feedback f = new Feedback("wodro");
        assertEquals("WO#R#", f.giveBetterHint());
    }

    @Test
    @DisplayName("testing if marklist is converted to string correctly")
    void markListToStringTest(){
        Feedback f = new Feedback();
        List<Mark.status> markL = new ArrayList<>();
        HashMap<Integer, Character> guessHolder = new HashMap<Integer, Character>();

        markL.add(Mark.status.CORRECT);
        markL.add(Mark.status.ABSENT);
        markL.add(Mark.status.ABSENT);
        markL.add(Mark.status.CORRECT);
        markL.add(Mark.status.ABSENT);

        guessHolder.put(0, 'w');
        guessHolder.put(1, 'a');
        guessHolder.put(2, 'a');
        guessHolder.put(3, 'r');
        guessHolder.put(4, 'a');


        assertEquals("W..R.", f.markListToString(markL, guessHolder));
    }



    @ParameterizedTest
    @MethodSource("provideHintExamples")
    static Stream<Arguments> provideHintExamples() {
        return Stream.of(
                Arguments.of(Mark.status.CORRECT, Mark.status.CORRECT, Mark.status.CORRECT),
                Arguments.of(Mark.status.CORRECT, Mark.status.PRESENT, Mark.status.ABSENT),
                Arguments.of(Mark.status.INVALID, Mark.status.INVALID, Mark.status.INVALID),
                Arguments.of(Mark.status.INVALID, Mark.status.INVALID, Mark.status.INVALID),
                Arguments.of(Mark.status.ABSENT, Mark.status.ABSENT, Mark.status.ABSENT));
    }
}
