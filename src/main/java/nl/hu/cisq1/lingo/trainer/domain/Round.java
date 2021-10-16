package nl.hu.cisq1.lingo.trainer.domain;

public class Round {
    private GameStatus gameStatus;
    private Feedback f;
    private int attempts = 0;


    //todo remove first constructor when word is actually being used
    public Round(Feedback feedback){
        this.f=feedback;
    }

    public Round(){

    }

    public boolean isGameStopped(){
        return gameStatus == GameStatus.STOPPED;
    }

    public int startRound(String attempt, String wordToGuess){
        Feedback feedback = new Feedback();
        attempts = 0;
        gameStatus=GameStatus.PLAYING;
        while (attempts <= 4 && !isGameStopped()) {
            feedback.setAttempt(attempt);
            if (feedback.getAttempt().equals(wordToGuess)) {
                gameStatus=GameStatus.STOPPED;
                return 5 * (5-attempts) +5;
            } else{
                attempts++;
                feedback.setAttempt(attempt);
                feedback.giveBetterHint();
            }
        }
        gameStatus=GameStatus.STOPPED;
        return 0;
    }
}
