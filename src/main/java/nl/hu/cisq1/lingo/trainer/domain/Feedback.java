package nl.hu.cisq1.lingo.trainer.domain;

import java.util.List;

public class Feedback {
    private String attempt;
    private List<Mark> markList;

    public Feedback(String attempt, List<Mark> markList) {
        this.attempt = attempt;
        this.markList = markList;
    }
    public enum Mark{
        INVALID,
        CORRECT,
        ABSENT,
        PRESENT
    }

    public List<Mark> getMarkList() {
        return markList;
    }

    public boolean isWordGuessed(Feedback feedback){
        boolean b = true;
        for(Mark m : feedback.getMarkList()){
            if (!m.equals(Mark.CORRECT)){
                b = false;
            }
        }
        return b;
    }
}
