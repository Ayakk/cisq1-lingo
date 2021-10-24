package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.CiTestConfiguration;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Import(CiTestConfiguration.class)
public class ServiceIntegrationTest {
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private WordService wordService;

    @Test
    @DisplayName("Testing guessing words using the service")
    void guessingWordTest(){
        wordService = mock(WordService.class);
        when(wordService.provideRandomWord(5)).thenReturn("appel");
        trainerService.startNewGame();
        trainerService.startNewRound();
        assertEquals(trainerService.guess("waord"), "W.ORD");
    }
}
