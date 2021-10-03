package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.exception.InvalidFeedbackException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

public class Feedback {
    private String attempt;
    private List<Mark> markList;
    private HashMap<Integer, String> hintList = new HashMap<Integer, String>();
    private Word w;

    public Feedback(){

    }

    public Feedback(String attempt) {
        this.attempt = attempt;
    }

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

    public List<Mark> giveBetterHint(){
        HashMap<Integer, Character> guessHolder = new HashMap<Integer, Character>();
        HashMap<Integer, Character> attemptHolder = new HashMap<Integer, Character>();
        List<Mark> markL = new ArrayList<Mark>();

        String s = "";

        for (int i = 0; i < getAttempt().length(); i++){
            char c = getAttempt().charAt(i);
            //Process char
            guessHolder.put(i, c);
        }

        for (int i = 0; i < w.getToGuessWord().length(); i++){
            char c = w.getToGuessWord().charAt(i);
            //Process char
            attemptHolder.put(i, c);
        }

        if (guessHolder.equals(attemptHolder)){
            for (int i = 0; i < guessHolder.size(); i++){
                markL.add(Mark.CORRECT);
            }
        } else if (guessHolder.size() != attemptHolder.size()){
            for (int i = 0; i < guessHolder.size(); i++)
                markL.add(Mark.INVALID);
        }else {
            for (int i = 0; i < guessHolder.size(); i++){
                if (guessHolder.get(i).equals(attemptHolder.get(i))){

                }
            }
        }

    }

    public Word getW() {
        return w;
    }

    public void setW(Word w) {
        this.w = w;
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
            //is Guessed starts on true
            boolean isGuessed = true;
            //for loop checks if ifGuessed should be put to false
            for(Mark m : feedback.getMarkList()){
                //checks if all marks are correct, if not isGuessed = false
                if (!m.equals(Mark.CORRECT)){
                    isGuessed = false;
                }
            }
            return isGuessed;
        }catch (InvalidFeedbackException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    public boolean wordIsInvalid(Feedback feedback){
        boolean isInvalid = false;
        String word = feedback.getAttempt();
        //if the word length is outside what is allowed isInvalid will become true
        if (word.length() < 4 || word.length() > 6){
            isInvalid = true;
        }
        return isInvalid;
    }


    public String giveHint(Feedback feedback){
        String attemptString = feedback.getAttempt();
        List<String> attemptStringtoList = new ArrayList<String>();
        List<Mark> markL = feedback.getMarkList();

        //for loop converts attemptString to an array of chars
        for (char c : attemptString.toCharArray()){
            //put string value of attempt in arraylist
            attemptStringtoList.add(String.valueOf(c));
        }
        System.out.println("CONTENT attemptStringtoList: \n" + attemptStringtoList);
        System.out.println("CONTENT marklist: \n" + markL);

        if (attemptString.length() != markL.size()){
            throw new InvalidFeedbackException();
        }

        int i = 0;
        for (Mark m : markL){
            if (m.equals(Mark.CORRECT)){
                hintList.put(i, attemptStringtoList.get(i).toUpperCase());
            }else if (m.equals(Mark.PRESENT)){
                hintList.put(i, "#");
            } else {
                hintList.put(i, ".");
            }
            i++;
        }

        String s = "";
        System.out.println("HASH VALUES: \n "+hintList.values());
        for (String a : hintList.values()){
            if (!a.equals("")){
                s+=a;
            }else {
                s+=".";
            }
        }
        return s;
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
