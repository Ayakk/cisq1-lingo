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

    public String startNewGame(String attempt){
        String response = startNewRound(attempt);
        return response;
    }

    public void guess(){

    }

    public String startNewRound(String attempt){
        game = new Game();
        round = new Round();
//        wordService.provideRandomWord(5) <- add as third parameter to the line below
        return game.startGame(attempt, round, "woord");
    }
}
