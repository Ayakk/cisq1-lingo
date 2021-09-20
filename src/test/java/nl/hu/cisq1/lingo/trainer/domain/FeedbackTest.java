package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {

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

}