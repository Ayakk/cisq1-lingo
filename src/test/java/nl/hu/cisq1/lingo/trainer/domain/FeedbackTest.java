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
    //TODO make the lists length automatically generated

    @Test
    @DisplayName("Word is guessed if all letters are correct")
    void wordIsGuessed(){
        Feedback f = new Feedback("woord", List.of(Feedback.Mark.CORRECT, Feedback.Mark.CORRECT, Feedback.Mark.CORRECT, Feedback.Mark.CORRECT, Feedback.Mark.CORRECT));
        assertTrue(f.isWordGuessed(f));
    }

    @Test
    @DisplayName("Word is not guessed if some or all letters are incorrect")
    void wordIsNotGuessed(){
        Feedback f = new Feedback("woord", List.of(Feedback.Mark.INVALID, Feedback.Mark.CORRECT, Feedback.Mark.CORRECT, Feedback.Mark.CORRECT, Feedback.Mark.CORRECT));
        assertFalse(f.isWordGuessed(f));
    }


    @Test
    @DisplayName("given word is invalid")
    void guessIsInvalid(){
        Feedback f = new Feedback("hek", List.of(Feedback.Mark.INVALID, Feedback.Mark.INVALID, Feedback.Mark.INVALID, Feedback.Mark.INVALID, Feedback.Mark.INVALID));
        assertTrue(f.wordIsInvalid(f));
    }

    @Test
    @DisplayName("given word is not invalid")
    void guessIsNotInvalid(){
        Feedback f = new Feedback("woord", List.of(Feedback.Mark.PRESENT, Feedback.Mark.PRESENT, Feedback.Mark.PRESENT, Feedback.Mark.PRESENT, Feedback.Mark.PRESENT));
        assertFalse(f.wordIsInvalid(f));
    }

    @Test
    @DisplayName("Test Invalid Feedback length")
    void InvalidFeedbackExceptionCheck(){
        assertThrows(InvalidFeedbackException.class, () -> new Feedback("woord", List.of(Feedback.Mark.CORRECT)));
    }

    @Test
    @DisplayName("Give hint")
    void giveHintTest(){
        Feedback f = new Feedback("woord", List.of(Feedback.Mark.CORRECT, Feedback.Mark.ABSENT, Feedback.Mark.ABSENT, Feedback.Mark.CORRECT, Feedback.Mark.ABSENT));
        assertEquals("W..R.", f.giveHint(f));
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
        List<Feedback.Mark> markL = new ArrayList<Feedback.Mark>();
        HashMap<Integer, Character> guessHolder = new HashMap<Integer, Character>();

        markL.add(Feedback.Mark.CORRECT);
        markL.add(Feedback.Mark.ABSENT);
        markL.add(Feedback.Mark.ABSENT);
        markL.add(Feedback.Mark.CORRECT);
        markL.add(Feedback.Mark.ABSENT);

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
                Arguments.of(Feedback.Mark.CORRECT, Feedback.Mark.CORRECT, Feedback.Mark.CORRECT),
                Arguments.of(Feedback.Mark.CORRECT, Feedback.Mark.PRESENT, Feedback.Mark.ABSENT),
                Arguments.of(Feedback.Mark.INVALID, Feedback.Mark.INVALID, Feedback.Mark.INVALID),
                Arguments.of(Feedback.Mark.INVALID, Feedback.Mark.INVALID, Feedback.Mark.INVALID),
                Arguments.of(Feedback.Mark.ABSENT, Feedback.Mark.ABSENT, Feedback.Mark.ABSENT));
    }
}
