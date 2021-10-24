package nl.hu.cisq1.lingo.trainer.domain;

public class Round {
    private GameStatus gameStatus;
    private Feedback f;
    private int attempts = 0;
    private int score = 0;
    private String wordToGuess;


    //todo remove first constructor when word is actually being used
    public Round(Feedback feedback){
        this.f=feedback;
    }

    public Round(){
        gameStatus=GameStatus.PLAYING;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
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

    public String newPlayRound(String attempt){
        Feedback feedback = new Feedback();
        if (attempts <= 4 && !isGameStopped()) {
            System.out.println(attempts);
            feedback.setAttempt(attempt);
            if (feedback.getAttempt().equals(wordToGuess)) {
                gameStatus=GameStatus.STOPPED;
                score = calculateScore(attempts);
                return "Gewonnen! U heeft " + score + " punten verdient!";
            } else{
                feedback.setAttempt(attempt);
                return feedback.giveBetterHint();
            }
        } else if (!isGameStopped()){
            gameStatus=GameStatus.STOPPED;
            setScore(calculateScore(attempts));
            return "Verloren! U heeft " + score + " punten verdient!";
        }
        return "";
    }

    public int calculateScore(int attempts){
        setScore(5 * (5-attempts) +5);
        return 5 * (5-attempts) +5;
    }

}
