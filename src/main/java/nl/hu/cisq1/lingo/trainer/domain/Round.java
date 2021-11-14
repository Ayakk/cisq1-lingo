package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.application.WordService;
import nl.hu.cisq1.lingo.words.data.SpringWordRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Round {
    private GameStatus gameStatus;
    private int attempts = 0;
    private int score = 0;
    private String wordToGuess;
    private boolean roundWon;

    //todo remove first constructor when word is actually being used

    public Round(){
        gameStatus=GameStatus.PLAYING;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public boolean isRoundWon() {
        return roundWon;
    }

    public void setRoundWon(boolean roundWon) {
        this.roundWon = roundWon;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isGameStopped(){
        return gameStatus == GameStatus.STOPPED;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean checkIfGameContinues(){
        return attempts <= 4 && !isGameStopped();
    }

    public String newPlayRound(String attempt){
        Feedback feedback = new Feedback();
        feedback.setWordToGuess(wordToGuess);
        if (checkIfGameContinues()) {
            feedback.setAttempt(attempt);
            if (feedback.getAttempt().equals(wordToGuess)) {
                gameStatus=GameStatus.STOPPED;
                score = calculateScore(attempts);
                roundWon = true;
                return "Gewonnen! U heeft " + score + " punten verdient!";
            } else{
                feedback.setAttempt(attempt);
                String feedbackBetterHint = feedback.giveBetterHint();
                String marklist = feedback.getMarkL().toString();
                return "Attempt: " + attempt + "\nFeedback: " + feedbackBetterHint +"\nMarklist: " + marklist;
            }
        } else {
            gameStatus=GameStatus.STOPPED;
            setScore(calculateScore(attempts));
            roundWon = false;
            return "Verloren! U heeft " + score + " punten verdient!";
        }
    }

    public int calculateScore(int attempts){
        setScore(5 * (5-attempts) +5);
        return 5 * (5-attempts) +5;
    }

}
