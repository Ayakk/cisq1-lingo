package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.application.WordService;
import nl.hu.cisq1.lingo.words.domain.Word;

import javax.persistence.*;

@Entity(name = "game")
public class Game {
    @Id
    @Column(unique = true, name = "game_id")
    @GeneratedValue
    private int game_id;
    private GameStatus gs;
    @Column(name = "score")
    private int score;
    @Column(name = "toGuessWord")
    private String wordToGuess;
    @Transient
    private Round round;
    @Transient
    private WordService wordService;
    @Transient
    private int nrCorrect =5;

    //TODO dependency injection round

    public Game(){

    }

    public Game(WordService ws){
        this.wordService = ws;
        round = new Round();
        wordToGuess = wordService.provideRandomWord(5);
        round.setWordToGuess(wordToGuess);
        round.setAttempts(0);
    }

    public Game(String word) {
        gs = GameStatus.STOPPED;
        this.wordToGuess=word;
    }

    public Round getRound() {
        return round;
    }

    public int getNrCorrect() {
        return nrCorrect;
    }

    public void setNrCorrect(int nrCorrect) {
        this.nrCorrect = nrCorrect;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public GameStatus getGameStatus() {
        return gs;
    }

    public int getScore() {
        return score;
    }

    public boolean checkIfRoundWon(){
        return round.isRoundWon();
    }

    public void gameResetFNextRound(){
        round.setAttempts(0);
        round.setGameStatus(GameStatus.PLAYING);
    }

    public String startGame(String attempt, Round round) {
        gs = GameStatus.PLAYING;
        String returnVal = round.newPlayRound(attempt);
        score += round.getScore();
        gs = GameStatus.STOPPED;
        return returnVal;
    }
}
