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

    public String startGame(String attempt, Round round, String wordToGuess) {
        gs = GameStatus.PLAYING;
        Score += round.startRound(attempt, wordToGuess);
        gs = GameStatus.STOPPED;
        return "You got "+Score+" points!";
    }
}
