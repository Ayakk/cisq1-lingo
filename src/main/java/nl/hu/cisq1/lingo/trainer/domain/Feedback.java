package nl.hu.cisq1.lingo.trainer.domain;

import java.util.*;

public class Feedback {
    private String attempt;
    private List<Mark> markL;
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
        this.markL = markList;
    }

    public String getAttempt() {
        return attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public List<Mark> getMarkL() {
        return markL;
    }

    public void setMarkL(List<Mark> markL) {
        this.markL = markL;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public boolean isWordGuessed(Feedback feedback) {
        return !feedback.getMarkL().contains(Mark.INVALID) && !feedback.getMarkL().contains(Mark.ABSENT) && !feedback.getMarkL().contains(Mark.PRESENT) && feedback.getAttempt().length() == feedback.getMarkL().size();
    }


    public boolean wordIsInvalid(String word) {
        //if the word length is outside what is allowed isInvalid will become true
        //word.matches checks if the string contains an integer
        return word.length() < 4 || word.length() > 6 || word.matches(".*\\d.*");
    }

    public void checkIfWordToGuessAssigned(){
        if (wordToGuess == null){
            wordToGuess="woord";
        }
    }

    public String giveBetterHint() {
        //gueesHolder contains the word that needs to be guessed
        //attemptholder contains the attempt of the user
        HashMap<Integer, Character> guessHolder = new HashMap<Integer, Character>();
        HashMap<Integer, Character> attemptHolder = new HashMap<Integer, Character>();
        markL = new ArrayList<>();

        checkIfWordToGuessAssigned();

        if (!wordIsInvalid(attempt)){
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
        } else{
            markL.add(Mark.INVALID);
        }
        setMarkL(markL);
        return markListToString(markL, guessHolder);
    }

    //convert list of feedback to a hintString
    public String markListToString(List<Mark> markL, HashMap<Integer, Character> guessHolder) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < markL.size(); i++) {
            if (markL.get(i).equals(Mark.CORRECT)) {
                //IF correct, correct letter gets placed
                returnString.append(String.valueOf(guessHolder.get(i)).toUpperCase());
            } else if (markL.get(i).equals(Mark.PRESENT)) {
                //IF present, # gets placed
                returnString.append("#");
            } else if (markL.get(i).equals(Mark.INVALID)) {
                //IF invalid, X gets placed
                returnString.append("X");
            } else {
                //Place . in every other case
                returnString.append(".");
            }
        }
        return returnString.toString();
    }
}
