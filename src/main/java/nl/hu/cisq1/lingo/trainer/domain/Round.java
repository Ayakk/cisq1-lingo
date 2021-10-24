package nl.hu.cisq1.lingo.trainer.domain;

public class Round {
    private GameStatus gameStatus;
    private int attempts = 0;
    private int score = 0;
    private String wordToGuess;


    //todo remove first constructor when word is actually being used

    public Round(){
        gameStatus=GameStatus.PLAYING;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
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
        if (checkIfGameContinues()) {
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
        } else {
            gameStatus=GameStatus.STOPPED;
            setScore(calculateScore(attempts));
            return "Verloren! U heeft " + score + " punten verdient!";
        }
    }

    public int calculateScore(int attempts){
        setScore(5 * (5-attempts) +5);
        return 5 * (5-attempts) +5;
    }

}
