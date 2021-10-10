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
        System.out.println("The word has " + wordToGuess.length() + " letters");
        while (attempts <= 4 && !isGameStopped()) {
            System.out.println("Round " + attempts);
            f.setAttempt(attempt);
            if (f.getAttempt().equals(wordToGuess)) {
                gameStatus=GameStatus.STOPPED;
                System.out.println("Correct!");
                return 5 * (5-attempts) +5;
            } else{
                attempts++;
                f.setAttempt(attempt);
                f.giveBetterHint();
            }
        }
        System.out.println("Game has ended!");
        gameStatus=GameStatus.STOPPED;
        return 0;
    }
}
