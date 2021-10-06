package nl.hu.cisq1.lingo.trainer.domain;


import nl.hu.cisq1.lingo.words.domain.Word;

public class Game {
    private Round r;
    private Word w;
    private GameStatus gs;
    private int Score;

    public Game(Round round, Word word) {
        gs = GameStatus.STOPPED;
        this.r = round;
        this.w = word;
    }

    public GameStatus getGameStatus() {
        return gs;
    }

    public int getScore() {
        return Score;
    }

    public void startGame(String attempt) {
        gs = GameStatus.PLAYING; //TODO enum gamestatus playing, waiting,
//        f.setAttempt(r.getUserInput());
        Score += r.startRound(attempt);
        System.out.println("You got "+Score+" points!");
        gs = GameStatus.WAITING;
        gs = GameStatus.STOPPED;
    }
    //TODO score
}
