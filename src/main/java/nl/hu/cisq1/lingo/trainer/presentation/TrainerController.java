package nl.hu.cisq1.lingo.trainer.presentation;

import nl.hu.cisq1.lingo.trainer.application.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public ResponseEntity<String> getID(@RequestBody String attempt){
        trainerService.startNewGame(attempt);
        System.out.println("received");
        return new ResponseEntity<>("Attempt received", HttpStatus.OK);
    }
}
