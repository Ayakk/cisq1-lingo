package nl.hu.cisq1.lingo.trainer.domain;


import nl.hu.cisq1.lingo.words.domain.Word;

public class Game {
    private Round r;
    private Word w;
    private GameStatus gameStatus;

    public Game(Round round, Word word) {
        gameStatus = GameStatus.STOPPED;
        this.r = round;
        this.w = word;
    }

    public gStatus getGameStatus() {
        return gameStatus;
    }

    public void startGame(String attempt){
        gameStatus=gStatus.PLAYING; //TODO enum gamestatus playing, waiting,
//        f.setAttempt(r.getUserInput());
        r.startRound(attempt);
        gameStatus=gStatus.WAITING;
        gameStatus= gStatus.STOPPED;
    }
    //TODO score
}
