package com.game.tennis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles the processing of a tennis game by taking a sequence of ball wins
 * and updating the game state.
 * Adapter Layer - Input/Output Handling
 *
 * @author abdelaziznasri
 */

public class TennisScoreProcessor {
    private static final Logger logger = LoggerFactory.getLogger(TennisScoreProcessor.class);
    public final TennisGame game;

    public TennisScoreProcessor() {
        this.game = new TennisGame();
    }
    public void processGameScore(String scoreSequence) {
        if (!isValidInput(scoreSequence)) {
            logger.error("Invalid input. Please make sure to use only 'A' and 'B' characters.");
            return;
        }

        for (char player : scoreSequence.toCharArray()) {

            if (game.isGameOver()) break;
            game.incrementPlayerScore(player);
           logger.info(game.getCurrentScore());
        }
    }
    private boolean isValidInput(String input) {
        return input != null && input.matches("[AB]+");
    }

}
