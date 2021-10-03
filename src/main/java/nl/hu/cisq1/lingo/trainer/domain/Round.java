package nl.hu.cisq1.lingo.trainer.domain;

import java.util.Scanner;

public class Round {
    private boolean roundStatus;
    private Feedback f;
    private Word w;
    private int attempts = 0;

    public Round() {
        roundStatus = false;
        f = new Feedback();
        w = new Word("woordje");
    }

    public Feedback getF() {
        return f;
    }

    public boolean getRoundStatus() {
        return roundStatus;
    }

    public void setRoundStatus(boolean roundStatus) {
        this.roundStatus = roundStatus;
    }

    public void setF(Feedback f) {
        this.f = f;
    }

    public Word getW() {
        return w;
    }

    public void setW(Word w) {
        this.w = w;
    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        return userInput;
    }

    public void startRound(){
        boolean wordGuessed = false;
        String word = w.getToGuessWord();

        if (wordGuessed != true && roundStatus != true){
            while (attempts <=5){
                attempts++;
//                String guess = getUserInput();
                String guess = "woord";
                f.setAttempt(guess);
                f.setW(w);
                f.giveBetterHint();
            }
        }
        roundStatus = true;
    }
}
