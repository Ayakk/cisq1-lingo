package nl.hu.cisq1.lingo.trainer.domain;

import java.util.Scanner;

public class Round {
    private boolean started;
    private Word w;

    public Round() {
        started = false;
        w = new Word("woordje");
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

}
