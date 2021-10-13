package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.words.application.WordService;

public class TrainerService {
    private WordService wordService;
    private SpringGameRepository springGameRepository;

    public TrainerService(WordService wordService) {
        this.wordService = wordService;
    }
}
