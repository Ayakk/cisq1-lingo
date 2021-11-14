package nl.hu.cisq1.lingo.trainer.presentation;

import nl.hu.cisq1.lingo.CiTestConfiguration;
import nl.hu.cisq1.lingo.trainer.application.TrainerService;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Import(CiTestConfiguration.class)
@AutoConfigureMockMvc
public class ControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TrainerController trainerController;

    @Test
    @DisplayName("Test if starting new game is successful")
    void testStartGame() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/startgame"))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Test if starting new game is successful")
    void testStartNextRound() throws Exception {
        WordService wordService = mock(WordService.class);
        TrainerService trainerService = mock(TrainerService.class);
        trainerService.startNewGame();
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/nextround"))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Test if guess is successful")
    void testGuess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/startgame"));
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/newround"));
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/guess/woord"))
                .andExpect(status().isOk());

    }

//    @Test
//    @DisplayName("Test if saving game is successful")
//    void testSaveGame() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/startgame"));
//        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/newround"));
//        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/guess/woord"));
//
//        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/savegame"))
//                .andExpect(status().isOk());
//    }
//TODO do more mocks not multiple posts in 1 method
//TODO test exceptions
}
