package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;

import java.util.*;

public class Feedback {
    private String attempt;
    private List<Mark> markList;
    private HashMap<Integer, String> hintList = new HashMap<Integer, String>();
    private Word w;
    private String wordToGuess;

    public Feedback() {

    }

    public Feedback(String attempt) {
        this.attempt = attempt;
    }

    public Feedback(String attempt, String GuessWord) {
        this.attempt = attempt;
        this.wordToGuess = GuessWord;
    }

    public Feedback(String attempt, List<Mark> markList) {
        this.attempt = attempt;
        wordToGuess="woord";
        this.markList = markList;
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

    public boolean isWordGuessed(Feedback feedback) {
        //is Guessed starts on true
        boolean isGuessed = true;
        //for loop checks if ifGuessed should be put to false
        for (Mark m : feedback.getMarkList()) {
            //checks if all marks are correct, if not isGuessed = false
            if (!m.equals(Mark.CORRECT)) {
                isGuessed = false;
            }
        }
        return isGuessed;
    }


    public boolean wordIsInvalid(Feedback feedback) {
        boolean isInvalid = false;
        String word = feedback.getAttempt();
        //if the word length is outside what is allowed isInvalid will become true
        if (word.length() < 4 || word.length() > 6) {
            isInvalid = true;
        }
        return isInvalid;
    }

    public String giveBetterHint() {
        HashMap<Integer, Character> guessHolder = new HashMap<Integer, Character>();
        HashMap<Integer, Character> attemptHolder = new HashMap<Integer, Character>();
        List<Mark> markL = new ArrayList<>();

        if (wordToGuess == null){
            wordToGuess="woord";
        }
        System.out.println("Attempt: " + getAttempt());
        System.out.println("ToGuessWord: " + wordToGuess);

        String returnString = "";

        for (int i = 0; i < getAttempt().length(); i++) {
            char c = getAttempt().charAt(i);
            //Process char
            guessHolder.put(i, c);
        }

        for (int i = 0; i < wordToGuess.length(); i++) {
            char c = wordToGuess.charAt(i);
            //Process char
            attemptHolder.put(i, c);
        }

        if (guessHolder.equals(attemptHolder)) {
            for (int i = 0; i < guessHolder.size(); i++) {
                markL.add(Mark.CORRECT);
            }
        } else if (guessHolder.size() != attemptHolder.size()) {
            for (int i = 0; i < guessHolder.size(); i++)
                markL.add(Mark.INVALID);
        } else {
            for (int i = 0; i < guessHolder.size(); i++) {
                if (attemptHolder.get(i).equals(guessHolder.get(i))) {
                    markL.add(Mark.CORRECT);
                } else if (attemptHolder.containsValue(guessHolder.get(i))) {
                    markL.add(Mark.PRESENT);
                } else {
                    markL.add(Mark.ABSENT);
                }
            }
        }
        setMarkList(markL);

        System.out.println("Attempt was: " + attempt);
        System.out.println("Feedback was: " + markListToString(markL, guessHolder));
        return markListToString(markL, guessHolder);
    }

    //convert list of feedback to string with hint
    public String markListToString(List<Mark> markL, HashMap<Integer, Character> guessHolder) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < markL.size(); i++) {
            if (markL.get(i).equals(Mark.CORRECT)) {
                returnString.append(String.valueOf(guessHolder.get(i)).toUpperCase());
            } else if (markL.get(i).equals(Mark.PRESENT)) {
                returnString.append("#");
            } else if (markL.get(i).equals(Mark.INVALID)) {
                returnString.append("X");
            } else {
                returnString.append(".");
            }
        }
        return returnString.toString();
    }
}
