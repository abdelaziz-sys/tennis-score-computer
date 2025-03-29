package com.game.tennis;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry for the tennis scoring process
 * Handle the user input
 *
 * @author abdelaziznasri
 */

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TennisScoreProcessor processor = new TennisScoreProcessor();

        logger.info("Enter the sequence of ball wins (A for Player A, B for Player B):");
        String scoreSequence = scanner.nextLine().toUpperCase();

        processor.processGameScore(scoreSequence);

        scanner.close();
    }
}