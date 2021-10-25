package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "game")
public class Game {
    @Id
    @Column(unique = true, name = "gameID")
    @GeneratedValue
    private int gameId;
    private GameStatus gs;
    @Column(name = "score")
    private int score;
    @Column(name = "toGuessWord")
    private String wordToGuess;

    //TODO dependency injection round

    public Game(){
        this.wordToGuess = "woord";
    }

    public Game(String word) {
        gs = GameStatus.STOPPED;
        this.wordToGuess=word;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public GameStatus getGameStatus() {
        return gs;
    }

    public int getScore() {
        return score;
    }

    public String startGame(String attempt, Round round) {
        gs = GameStatus.PLAYING;
        round.setWordToGuess(wordToGuess);
        String returnVal = round.newPlayRound(attempt);
        score += round.getScore();
        gs = GameStatus.STOPPED;
        return returnVal;
    }
}
