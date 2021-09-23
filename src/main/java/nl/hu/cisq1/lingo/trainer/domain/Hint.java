package nl.hu.cisq1.lingo.trainer.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Hint {
    HashMap<Integer, String> hintList = new HashMap<Integer, String>();

    public HashMap<Integer, String> getHintList() {
        return hintList;
    }

    public void setHintList(HashMap<Integer, String> hintList) {
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
