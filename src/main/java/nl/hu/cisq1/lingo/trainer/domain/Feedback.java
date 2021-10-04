package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;
import nl.hu.cisq1.lingo.words.domain.exception.InvalidFeedbackException;

import java.util.*;

public class Feedback {
    private String attempt;
    private List<Mark.status> markList;
    private HashMap<Integer, String> hintList = new HashMap<Integer, String>();
    private Word w;

    public Feedback(){

    }

    public Feedback(String attempt) {
        this.attempt = attempt;
        w = new Word();
    }

    public Feedback(String attempt, List<Mark.status> markList) {
        this.attempt = attempt;
        this.markList = markList;
    }


    public String getAttempt() {
        return attempt;
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

    public List<Mark.status> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark.status> markList) {
        this.markList = markList;
    }

    public boolean isWordGuessed(Feedback feedback){
        try{ //TODO geen try catch nodig--> check opdracht named constructor
            //is Guessed starts on true
            boolean isGuessed = true;
            //for loop checks if ifGuessed should be put to false
            for(Mark.status m : feedback.getMarkList()){
                //checks if all marks are correct, if not isGuessed = false
                if (!m.equals(Mark.status.CORRECT)){
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

    public String giveBetterHint(){
        HashMap<Integer, Character> guessHolder = new HashMap<Integer, Character>();
        HashMap<Integer, Character> attemptHolder = new HashMap<Integer, Character>();
        List<Mark.status> markL = new ArrayList<>();

        String wordToGuess = "woord";
        System.out.println("Attempt: " + getAttempt());
        System.out.println("ToGuessWord: " + wordToGuess);

        String returnString = "";

        for (int i = 0; i < getAttempt().length(); i++){
            char c = getAttempt().charAt(i);
            //Process char
            guessHolder.put(i, c);
        }

        for (int i = 0; i < wordToGuess.length(); i++){
            char c = wordToGuess.charAt(i);
            //Process char
            attemptHolder.put(i, c);
        }

        if (guessHolder.equals(attemptHolder)){
            for (int i = 0; i < guessHolder.size(); i++){
                markL.add(Mark.status.CORRECT);
            }
        } else if (guessHolder.size() != attemptHolder.size()){
            for (int i = 0; i < guessHolder.size(); i++)
                markL.add(Mark.status.INVALID);
        }else {
            for (int i = 0; i < guessHolder.size(); i++){
                if (attemptHolder.get(i).equals(guessHolder.get(i))){
                    markL.add(Mark.status.CORRECT);
                } else if (attemptHolder.containsValue(guessHolder.get(i))){
                    markL.add(Mark.status.PRESENT);
                } else{
                    markL.add(Mark.status.ABSENT);
                }
            }
        }
        setMarkList(markL);

        System.out.println("Attempt was: " + attempt);
        System.out.println("Feedback was: " + markListToString(markL, guessHolder));
        return markListToString(markL, guessHolder);
    }

    //convert list of feedback to string with hint
    public String markListToString(List<Mark.status> markL, HashMap<Integer, Character> guessHolder){
        String returnString = "";
        for (int i = 0; i < markL.size(); i++) {
            if (markL.get(i).equals(Mark.status.CORRECT)) {
                returnString += String.valueOf(guessHolder.get(i)).toUpperCase();
            } else if (markL.get(i).equals(Mark.status.PRESENT)) {
                returnString += "#";
            } else if (markL.get(i).equals(Mark.status.INVALID)) {
                returnString += "X";
            } else {
                returnString += ".";
            }
        }
        return returnString;
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
