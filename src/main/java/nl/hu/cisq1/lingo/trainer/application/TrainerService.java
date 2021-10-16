package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.trainer.domain.Feedback;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.domain.Round;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    private WordService wordService;
    private Game game;
    private Round round;
    private SpringGameRepository springGameRepository;

    public TrainerService(WordService wordService) {
        this.wordService = wordService;
    }

    public void startNewGame(String attempt){
        game = new Game();
        round = new Round();
        game.startGame(attempt, round, wordService.provideRandomWord(5));
    }

    public void guess(){

    }

    public void startNewRound(){

    }
}
