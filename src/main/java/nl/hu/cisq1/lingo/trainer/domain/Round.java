package nl.hu.cisq1.lingo.trainer.domain;

public class Round {
    private GameStatus gameStatus;
    private Feedback f;
    private int attempts = 0;


    //todo remove first constructor when word is actually being used
    public Round(Feedback feedback){
        this.f=feedback;
    }

    public boolean isGameStopped(){
        return gameStatus == GameStatus.STOPPED;
    }

    public int startRound(String attempt){
        attempts = 0;
        gameStatus=GameStatus.PLAYING;
        String wordToGuess = "woord";
        while (attempts <= 4 && !isGameStopped()) {
            f.setAttempt(attempt);
            if (f.getAttempt().equals(wordToGuess)) {
                gameStatus=GameStatus.STOPPED;
                return 5 * (5-attempts) +5;
            } else{
                attempts++;
                f.setAttempt(attempt);
                f.giveBetterHint();
            }
        }
        gameStatus=GameStatus.STOPPED;
        return 0;
    }
}
