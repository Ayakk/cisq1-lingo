package nl.hu.cisq1.lingo.trainer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {
    @Id
    @Column(unique = true)
    private int gameId;
    private GameStatus gs;
    private int Score;

    public Game() {
        gs = GameStatus.STOPPED;
    }

    public GameStatus getGameStatus() {
        return gs;
    }

    public int getScore() {
        return Score;
    }

    public void startGame(String attempt, Round round) {
        gs = GameStatus.PLAYING;
        Score += round.startRound(attempt);
        System.out.println("You got "+Score+" points!");
        gs = GameStatus.STOPPED;
    }
}
