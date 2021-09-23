package nl.hu.cisq1.lingo.trainer.domain;

import java.util.List;
import java.util.Objects;

public class Hint {
    private List<String> hintList;

    public Hint(List<String> hintList) {
        this.hintList = hintList;
    }

    public List<String> getHintList() {
        return hintList;
    }

    public void setHintList(List<String> hintList) {
        this.hintList = hintList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hint hint = (Hint) o;
        return Objects.equals(hintList, hint.hintList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hintList);
    }

    @Override
    public String toString() {
        return "Hint{" +
                "hintList=" + hintList +
                '}';
    }
}
