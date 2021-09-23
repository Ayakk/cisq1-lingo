package nl.hu.cisq1.lingo.trainer.domain;

import com.sun.xml.bind.v2.TODO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;
import java.util.List;

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
}