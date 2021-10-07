package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.words.domain.Word;

import java.util.Scanner;

public class Round {
    private GameStatus gameStatus;
    private Feedback f;
    private Word w;
    private int attempts = 0;



    public Round(Feedback feedback, Word word) {
        this.f = feedback;
        this.w = word;
    }

    public int startRound(String attempt){
        attempts = 0;
        gameStatus=GameStatus.PLAYING;
        String wordToGuess = "woord";
        System.out.println("The word has " + wordToGuess.length() + " letters");
        while (attempts <= 4 && gameStatus!=GameStatus.STOPPED) {
            System.out.println("Round " + attempts);
            f.setAttempt(attempt);
            gameStatus=GameStatus.WAITING;
            if (f.getAttempt().equals(wordToGuess)) {
                gameStatus=GameStatus.STOPPED;
                System.out.println("Correct!");
                return 5 * (5-attempts) +5;
            } else{
                attempts++;
                f.setAttempt(attempt);
                f.giveBetterHint();
            }
        }
        System.out.println("Game has ended!");
        gameStatus=GameStatus.STOPPED;
        return 0;
    }
}
