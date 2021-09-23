package nl.hu.cisq1.lingo.words.domain.exception;

public class InvalidFeedbackException extends RuntimeException{
    public InvalidFeedbackException() {
        super("Word Length and Feedback doesn't match!");
    }
}
