package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.domain.Round;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerService {
    private WordService wordService;
    private Game game;
    private Round round;

    @Autowired
    private SpringGameRepository springGameRepository;

    public TrainerService(WordService wordService) {
        this.wordService = wordService;
    }

    public void startNewGame(){
        game = new Game(wordService.provideRandomWord(5));
    }

    public String guess(String attempt){
        String returnVal =  round.newPlayRound(attempt);
        round.setAttempts(round.getAttempts()+1);
        return returnVal;
    }

    public void loadGame(int id){
        Optional<Game> g = springGameRepository.findById(id);
        g.ifPresent(value -> game = value);
    }

    public void saveGame(){
        springGameRepository.save(game);
    }

    public void startNewRound(){
        try {
            game.setScore(game.getScore()+round.getScore());
        } catch (Exception e){
            System.out.println(e);
        }
        round = new Round();
        round.setWordToGuess(game.getWordToGuess());
        System.out.println(game.getScore());
        round.setAttempts(0);
    }
}