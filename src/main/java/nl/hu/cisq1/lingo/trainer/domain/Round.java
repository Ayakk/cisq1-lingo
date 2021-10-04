package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;

import java.util.Scanner;

public class Round {
    private boolean roundStatus;
    private Feedback f;
    private Word w;
    private int attempts = 0;

    public Round(Feedback feedback) {
        roundStatus = false;
        f = new Feedback();
    }

    public void startRound(String attempt){
        boolean wordGuessed = false;
        w = new Word("woord");
        String word = w.getValue();
        f.setW(w);
        System.out.println("The word has " + w.getValue().length() + " letters");
        while (attempts <= 4 && wordGuessed != true) {
            attempts++;
            System.out.println("Round " + attempts);
            f.setAttempt(attempt);
            if (f.getAttempt().equals(f.getW().getValue())) {
                wordGuessed = true;
                System.out.println("Correct!");
            } else{
                f.setAttempt(attempt);
                f.giveBetterHint();
            }
        }
        System.out.println("Game has ended!");
        roundStatus = true;
    }
}
