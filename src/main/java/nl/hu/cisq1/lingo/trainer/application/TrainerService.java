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

    @Autowired
    private SpringGameRepository springGameRepository;

    public TrainerService(WordService wordService) {
        this.wordService = wordService;
    }

    public String startNewGame(){
        game = new Game(wordService);
        return game.getWordToGuess();
    }

    public String guess(String attempt){
        Round roundFromGame = game.getRound();
        String returnVal =  roundFromGame.newPlayRound(attempt);
        roundFromGame.setAttempts(roundFromGame.getAttempts()+1);
        return returnVal;
    }

    public void loadGame(int id){
        Optional<Game> g = springGameRepository.findById(id);
        g.ifPresent(value -> game = value);
    }

    public boolean saveGame(){
        try{
            springGameRepository.save(game);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Optional<Game> findgame(int id){
        if (springGameRepository.findById(id).isPresent()){
            Optional<Game> ga1 = springGameRepository.findById(id);
            return ga1;
        }
        return null;
    }
}