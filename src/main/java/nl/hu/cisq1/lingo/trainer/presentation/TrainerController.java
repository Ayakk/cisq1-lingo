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

    @PostMapping(("/guess/{attempt}"))
    public ResponseEntity<String> getID(@PathVariable String attempt){
        String response = trainerService.startNewGame(attempt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
