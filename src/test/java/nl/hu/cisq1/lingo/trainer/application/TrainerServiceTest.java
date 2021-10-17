package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TrainerServiceTest {


    @Test
    @DisplayName("testing the length of the word from the provideRandomWord method")
    void wordLengthTest() {
        WordService wordService = mock(WordService.class);
        SpringGameRepository gameRepository = mock(SpringGameRepository.class);
        TrainerService service = mock(TrainerService.class);
        when(wordService.provideRandomWord(5)).thenReturn("appel");
        assertEquals(5, wordService.provideRandomWord(5).length());
        verify(wordService, times(1)).provideRandomWord(5);
    }

    @Test
    void guess() {
    }

    @Test
    void startNewRound() {
    }
}