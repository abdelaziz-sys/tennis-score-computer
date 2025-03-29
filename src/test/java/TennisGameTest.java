import static org.junit.jupiter.api.Assertions.*;

import com.game.tennis.TennisGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TennisGameTest {
    private TennisGame game;

    @BeforeEach
    void setUp() {
        game = new TennisGame();
    }

    @Test
    @DisplayName("Initial game score" )
    void testInitialScore() {
        assertEquals("Player A : 0 / Player B : 0", game.getCurrentScore());
    }

    @Test
    void testPlayerAScoresOnce() {
        // when
        game.incrementPlayerScore('A');
        //then
        assertEquals("Player A : 15 / Player B : 0", game.getCurrentScore());
    }

    @Test
    void testPlayerBScoresOnce() {
        //when
        game.incrementPlayerScore('B');
        //then
        assertEquals("Player A : 0 / Player B : 15", game.getCurrentScore());
    }

    @Test
    void testDeuceScenario() {
        //when
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        //then
        assertEquals("Deuce", game.getCurrentScore());
    }

    @Test
    void testAdvantagePlayerA() {
        //when
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('A');
        //then
        assertEquals("Advantage A", game.getCurrentScore());
    }

    @Test
    void testAdvantagePlayerB() {
        //when
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('B');
        //then
        assertEquals("Advantage B", game.getCurrentScore());
    }

    @Test
    void testPlayerAWinsGame() {
        //when
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('A');
        //then
        assertEquals("Player A wins the game", game.getCurrentScore());
        assertTrue(game.isGameOver());
    }

    @Test
    void testPlayerBWinsGame() {
        //when
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        //then
        assertEquals("Player B wins the game", game.getCurrentScore());
        assertTrue(game.isGameOver());
    }

    @Test
    void gamsShouldStopAfterWin() {
        //when
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('A');
        game.incrementPlayerScore('B');
        game.incrementPlayerScore('B');
        //then
        assertEquals("Player A wins the game", game.getCurrentScore());
    }
}
