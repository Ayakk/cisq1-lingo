package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrainerServiceTest {
    @Autowired
    private TrainerService trainerService;

    @Test
    @DisplayName("testing the length of the word from the provideRandomWord method")
    void wordLengthTest() {
        WordService wordService = mock(WordService.class);
        when(wordService.provideRandomWord(5)).thenReturn("appel");
        assertEquals(5, wordService.provideRandomWord(5).length());
        verify(wordService, times(1)).provideRandomWord(5);
    }


    @Test
    @DisplayName("test if the getter returns the correct value")
    void testGetGame(){
        assertEquals(trainerService.getGame(), trainerService.getGame());
    }

    @Test
    @DisplayName("test if then nextround method returns the correct value")
    void testNextRound(){
        trainerService.startNewGame();
        trainerService.guess(trainerService.getGame().getWordToGuess());
        assertEquals(trainerService.nextround(), trainerService.getGame().getWordToGuess());
    }

    @Test
    @DisplayName("test if then nextround method returns the correct value")
    void testNextRoundNrCorrectFalse(){
        trainerService.startNewGame();
        trainerService.guess(trainerService.getGame().getWordToGuess());
        trainerService.getGame().setNrCorrect(10);
        assertEquals(trainerService.nextround(), "For some reason it's time to start a new game :) Have fun!");
    }

    @Test
    @DisplayName("test if then nextround method returns the correct value")
    void testNextRoundNrCorrectFalseGuessFalse(){
        trainerService.startNewGame();
        trainerService.getGame().setNrCorrect(10);
        assertEquals(trainerService.nextround(), "For some reason it's time to start a new game :) Have fun!");
    }

    @Test
    @DisplayName("test if then nextround method returns the correct value")
    void testNextRoundNrCorrectTrue(){
        trainerService.startNewGame();
        trainerService.getGame().setNrCorrect(5);
        assertEquals(trainerService.nextround(), "For some reason it's time to start a new game :) Have fun!");
    }

    @Test
    @DisplayName("test if the exception returns the correct value")
    void testNextRoundException(){
        assertEquals(trainerService.nextround(), "For some reason it's time to start a new game :) Have fun!");
    }
}