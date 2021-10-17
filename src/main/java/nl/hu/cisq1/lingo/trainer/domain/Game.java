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

    public void setScore(int score) {
        Score = score;
    }

    public GameStatus getGameStatus() {
        return gs;
    }

    public int getScore() {
        return Score;
    }

    public String startGame(String attempt, Round round, String wordToGuess) {
        gs = GameStatus.PLAYING;
        String returnVal = round.newPlayRound(attempt, wordToGuess);
        Score += round.getScore();
        gs = GameStatus.STOPPED;
        return returnVal;
    }
}
