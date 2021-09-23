package nl.hu.cisq1.lingo.trainer.domain;

import java.util.Objects;

public class Word {
    private String toGuessWord;

    public Word(String toGuessWord) {
        this.toGuessWord = toGuessWord;
    }

    public String getToGuessWord() {
        return toGuessWord;
    }

    public void setToGuessWord(String toGuessWord) {
        this.toGuessWord = toGuessWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(toGuessWord, word.toGuessWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toGuessWord);
    }

    @Override
    public String toString() {
        return "Word{" +
                "toGuessWord='" + toGuessWord + '\'' +
                '}';
    }
}
