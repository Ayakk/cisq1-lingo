package nl.hu.cisq1.lingo.trainer.domain;


import nl.hu.cisq1.lingo.words.domain.Word;

public class Game {
    private Round r;
    private Word w; //TODO gebruik word paackage
    private boolean gameStatus;

    public Game(Round round, Word word) {
        gameStatus = false;
        this.r = round;
        this.w = word;
    }


    public void startGame(){
        gameStatus=true; //TODO enum gamestatus playing, waiting,
//        f.setAttempt(r.getUserInput());
        r.startRound("test");
        gameStatus= false;
    }
    //TODO score
}
