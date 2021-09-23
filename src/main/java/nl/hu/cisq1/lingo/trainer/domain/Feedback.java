package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.exception.InvalidFeedbackException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

public class Feedback {
    private String attempt;
    private List<Mark> markList;

    public Feedback(String attempt, List<Mark> markList) {
        this.attempt = attempt;
        this.markList = markList;
    }
    public enum Mark{
        INVALID,
        CORRECT,
        ABSENT,
        PRESENT
    }

    public String getAttempt() {
        return attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }

    public boolean isWordGuessed(Feedback feedback){
        try{
            boolean b = true;
            for(Mark m : feedback.getMarkList()){
                if (!m.equals(Mark.CORRECT)){
                    b = false;
                }
            }
            return b;
        }catch (InvalidFeedbackException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    public boolean wordIsInvalid(Feedback feedback){
        boolean b = false;
        String word = feedback.getAttempt();
        if (word.length() < 4 || word.length() > 6){
            b = true;
        }
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(attempt, feedback.attempt) &&
                Objects.equals(markList, feedback.markList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attempt, markList);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "attempt='" + attempt + '\'' +
                ", markList=" + markList +
                '}';
    }
}
