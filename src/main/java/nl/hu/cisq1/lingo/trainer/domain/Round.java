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
        w = new Word("woord");
        String word = w.getToGuessWord();


        while (attempts <= 4 && wordGuessed != true) {
            attempts++;
//                String guess = getUserInput();
            String attempt = "woord";
            f.setAttempt(attempt);
            f.setW(w);
            f.giveBetterHint();
            if (f.getAttempt().equals(f.getW().getToGuessWord())) {
                wordGuessed = true;
                System.out.println("Correct!");
            }
        }

        roundStatus = true;
    }
}
