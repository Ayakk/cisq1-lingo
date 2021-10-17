package nl.hu.cisq1.lingo.trainer.presentation;

import nl.hu.cisq1.lingo.trainer.application.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping("/startgame")
    public ResponseEntity<String> startGame(){
        trainerService.startNewGame();
        return new ResponseEntity<>("Started game", HttpStatus.OK);
    }

    @PostMapping(("/newround"))
    public ResponseEntity<String> startNewRound(){
        trainerService.startNewRound();
        return new ResponseEntity<>("Round has been started", HttpStatus.OK);
    }

    @PostMapping("/savegame")
    public ResponseEntity<String> saveGame(){
        trainerService.saveGame();
        return new ResponseEntity<>("Game has been saved", HttpStatus.OK);
    }

    @PostMapping(("/loadgame/{id}"))
    public ResponseEntity<String> loadGame(@PathVariable int id){
        trainerService.loadGame(id);
        return new ResponseEntity<>("Game has been loaded", HttpStatus.OK);
    }

    @PostMapping(("/guess/{attempt}"))
    public ResponseEntity<String> guess(@PathVariable String attempt){
        String response = trainerService.guess(attempt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}