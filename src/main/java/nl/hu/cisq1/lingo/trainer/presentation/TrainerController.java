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
        return new ResponseEntity<>("Started game", HttpStatus.OK);
    }

    @PostMapping(("/guess/{attempt}"))
    public ResponseEntity<String> playRound(@PathVariable String attempt){
        String response = trainerService.startNewGame(attempt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}