package nl.hu.cisq1.lingo.trainer.domain;


import nl.hu.cisq1.lingo.words.domain.Word;

public class Game {
    private Round r;
    private Word w; //TODO gebruik word paackage
    private gStatus gameStatus;

    public Game(Round round, Word word) {
        gameStatus = gStatus.STOPPED;
        this.r = round;
        this.w = word;
    }

    public enum gStatus{
        PLAYING,
        WAITING,
        STOPPED
    }


    public void startGame(){
        gameStatus=gStatus.PLAYING; //TODO enum gamestatus playing, waiting,
//        f.setAttempt(r.getUserInput());
        r.startRound("woord");
        gameStatus= gStatus.STOPPED;
    }
    //TODO score
}
