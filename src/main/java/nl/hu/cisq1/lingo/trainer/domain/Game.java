package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;

public class Game {
    private Round r;
    private GameStatus gs;
    private int Score;



    public Game(Round round) {
        gs = GameStatus.STOPPED;
        this.r = round;
    }

    public GameStatus getGameStatus() {
        return gs;
    }

    public int getScore() {
        return Score;
    }

    public void startGame(String attempt) {
        gs = GameStatus.PLAYING;
        Score += r.startRound(attempt);
        System.out.println("You got "+Score+" points!");
        gs = GameStatus.STOPPED;
    }
}
