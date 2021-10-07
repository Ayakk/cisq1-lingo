package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {
    @Test
    @DisplayName("Word is guessed if all letters are correct")
    void wordIsGuessed() {
        Feedback f = new Feedback("woord", List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT));
        assertTrue(f.isWordGuessed(f));
    }

    @Test
    @DisplayName("Word is not guessed if some or all letters are incorrect")
    void wordIsNotGuessed() {
        Feedback f = new Feedback("woord", List.of(Mark.INVALID, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT));
        assertFalse(f.isWordGuessed(f));
    }


    @Test
    @DisplayName("given word is invalid")
    void guessIsInvalid() {
        Feedback f = new Feedback("hek", List.of(Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID));
        assertTrue(f.wordIsInvalid(f));
    }

    @Test
    @DisplayName("given word is not invalid")
    void guessValid() {
        Feedback f = new Feedback("woord", List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT));
        assertFalse(f.wordIsInvalid(f));
    }

    @Test
    @DisplayName("Give hint")
    void giveHintTest() {
        Feedback f = new Feedback("waara", List.of(Mark.CORRECT, Mark.ABSENT, Mark.ABSENT, Mark.CORRECT, Mark.ABSENT));
        assertEquals("W..R.", f.giveBetterHint());
    }

    @Test
    @DisplayName("Give hint")
    void giveBetterHintTest() {
        Feedback f = new Feedback("wodro");
        assertEquals("WO#R#", f.giveBetterHint());
    }

    @Test
    @DisplayName("Gives valid word but invalid list")
    void giveBadHintTest() {
        Feedback f = new Feedback("waara", List.of(Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID));
        assertFalse(f.wordIsInvalid(f));
    }

    @Test
    @DisplayName("testing if marklist is converted to string correctly")
    void markListToStringTest() {
        Feedback f = new Feedback();
        List<Mark> markL = new ArrayList<>();
        HashMap<Integer, Character> guessHolder = new HashMap<Integer, Character>();

        markL.add(Mark.CORRECT);
        markL.add(Mark.ABSENT);
        markL.add(Mark.ABSENT);
        markL.add(Mark.CORRECT);
        markL.add(Mark.ABSENT);

        guessHolder.put(0, 'w');
        guessHolder.put(1, 'a');
        guessHolder.put(2, 'a');
        guessHolder.put(3, 'r');
        guessHolder.put(4, 'a');


        assertEquals("W..R.", f.markListToString(markL, guessHolder));
    }

    static Stream<Arguments> provideHintExamples() {
        return Stream.of(
                Arguments.of(new Feedback("banaan", "banana"), "BANA##"),
                Arguments.of(new Feedback("ksuir", "kruis"), "K#UI#"),
                Arguments.of(new Feedback("kaasje", "kastje"), "KA##JE"),
                Arguments.of(new Feedback("aaabbb", "bbbaaa"), "######"),
                Arguments.of(new Feedback("aaabab", "bbbaaa"), "####A#"),
                Arguments.of(new Feedback("aaaaaa", "bbbbbb"), "......"),
                Arguments.of(new Feedback("gehoor", "onmens"), ".#.##."),
                Arguments.of(new Feedback("aabbcc", "abcabc"), "A####C"),
                Arguments.of(new Feedback("alianna", "liniaal"), "#######"),
                Arguments.of(new Feedback("heren", "haren"), "H#REN"),
                Arguments.of(new Feedback("eeaaae", "aaeeae"), "####AE"),
                Arguments.of(new Feedback("a", "aaaaa"), "X")
        );
    }

    @ParameterizedTest
    @MethodSource("provideHintExamples")
    @DisplayName("test")
    void test(Feedback feedback, String expectedHint) {
        assertEquals(feedback.giveBetterHint(), expectedHint);
    }
}
