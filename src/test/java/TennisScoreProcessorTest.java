import static org.junit.jupiter.api.Assertions.*;

import com.game.tennis.TennisScoreProcessor;
import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TennisScoreProcessorTest {
    private TennisScoreProcessor processor;
    private final LogCaptor logCaptor = LogCaptor.forClass(TennisScoreProcessor.class);

    @BeforeEach
    void setUp() {
        processor = new TennisScoreProcessor();
    }

    @Test
    void testValidSequence() {
        processor.processGameScore("ABABAA");

        assertTrue(logCaptor.getInfoLogs().contains("Player A : 15 / Player B : 0"));
        assertTrue(logCaptor.getInfoLogs().contains("Player A : 15 / Player B : 15"));
        assertTrue(logCaptor.getInfoLogs().contains("Player A : 30 / Player B : 30"));
        assertTrue(logCaptor.getInfoLogs().contains("Player A : 40 / Player B : 30"));
        assertTrue(logCaptor.getInfoLogs().contains("Player A wins the game"));
    }

    @Test
    void testInvalidInput() {

        processor.processGameScore("ABXABA");
        assertTrue(logCaptor.getErrorLogs().contains("Invalid input. Please make sure to use only 'A' and 'B' characters."));

    }

    @Test
    @DisplayName("The game should end when we have a winner")
    void testGameEndsOnWin() {
        // Given: A score sequence where Player A wins
        String inputSequence = "AAAABBBBBB";

        // When: We process the core
        processor.processGameScore(inputSequence);

        // Then: the game should end and display A as the winner

        assertTrue(logCaptor.getInfoLogs().contains("Player A : 15 / Player B : 0"));
        assertTrue(logCaptor.getInfoLogs().contains("Player A : 30 / Player B : 0"));
        assertTrue(logCaptor.getInfoLogs().contains("Player A : 40 / Player B : 0"));
        assertTrue(logCaptor.getInfoLogs().contains("Player A wins the game"));

    }
}
