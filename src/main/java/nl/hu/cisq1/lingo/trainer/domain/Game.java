package nl.hu.cisq1.lingo.trainer.domain;


public class Game {
    private Feedback f;
    private Round r;
    private Word w;
    private boolean gameStatus;

    public Game() {
        gameStatus = false;
        f = new Feedback();
        r = new Round();
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
        gameStatus=true;
//        f.setAttempt(r.getUserInput());
        r.setF(f);
        r.setW(w);
        r.startRound();

    }
}
