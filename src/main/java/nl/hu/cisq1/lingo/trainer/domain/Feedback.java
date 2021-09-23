package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.exception.InvalidFeedbackException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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

    public String giveHint(Feedback feedback){
        String att = feedback.getAttempt();
        List<String> emptylist = new ArrayList<String>();
        List<String> hintList = new ArrayList<String>();
        List<Mark> markL = feedback.getMarkList();
        Hint h = new Hint(hintList);
        for (char c : att.toCharArray()){
            emptylist.add(String.valueOf(c));
        }
        System.out.println("CONTENT emptylist: \n" + emptylist);
        System.out.println("CONTENT marklist: \n" + markL);

        if (att.length() != markL.size()){
            throw new InvalidFeedbackException();
        }

        for (Mark m : markL){
            
        }
        return "";
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
