package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class TrainerServiceTest {


    @Test
    void startNewGame() {
        WordService wordService = mock(WordService.class);
        SpringGameRepository gameRepository = mock(SpringGameRepository.class);
        TrainerService service = new TrainerService(wordService);
        when(wordService.provideRandomWord(5)).thenReturn("appel");
        verify(wordService, times(1)).provideRandomWord(5);
    }

    @Test
    void guess() {
    }

    @Test
    void startNewRound() {
    }
}