package nl.hu.cisq1.lingo.trainer.domain;


public class Game {
    private Round r;
    private Word w; //TODO gebruik word paackage
    private boolean gameStatus;

    public Game(Round round) {
        gameStatus = false;
        this.r = round;
        w = new Word("woord");
    }

    public boolean getStatus() {
        return gameStatus;
    }

    public void setStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Feedback getF() {
        return f;
    }

    public void setF(Feedback f) {
        this.f = f;
    }

    public Round getR() {
        return r;
    }

    public void setR(Round r) {
        this.r = r;
    }

    public Word getW() {
        return w;
    }

    public void setW(Word w) {
        this.w = w;
    }

    public void startGame(){
        gameStatus=true; //TODO enum gamestatus playing, waiting,
//        f.setAttempt(r.getUserInput());
        r.setF(f);
        r.setW(w);
        r.startRound();
        gameStatus= false;
    }
    //TODO score
}
