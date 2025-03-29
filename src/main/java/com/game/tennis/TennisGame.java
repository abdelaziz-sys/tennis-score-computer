package com.game.tennis;

import java.util.Map;

/**
 * Represents a Tennis game between two players (Player A and Player B).
 * This class manages the game logic, including scoring and determining the winner.
 *
 * @author abdelaziznasri00
 */
public class TennisGame {
    private static final Map<Integer, String> SCORE_MAP = Map.of(
            0, "0",
            1, "15",
            2, "30",
            3, "40"
    );
    private int playerAScore;
    private int playerBScore;
    private boolean gameOver;
    private String winner;

    public void incrementPlayerScore(char player) {
        if (!gameOver) {
            if (player == 'A') playerAScore++;
            else playerBScore++;
            checkForWinner();
        }
    }

    private void checkForWinner() {
        if ((playerAScore >= 4 || playerBScore >= 4) &&
                Math.abs(playerAScore - playerBScore) >= 2) {
            gameOver = true;
            winner = playerAScore > playerBScore ? "A" : "B";
        }
    }

    public String getCurrentScore() {
        if (gameOver) {
            return "Player " + winner + " wins the game";
        }
        if (playerAScore >= 3 && playerBScore >= 3) {
            return (playerAScore == playerBScore) ? "Deuce" :
                    "Advantage " + (playerAScore > playerBScore ? "A" : "B");
        }
        return String.format("Player A : %s / Player B : %s",
                SCORE_MAP.getOrDefault(playerAScore, "40"),
                SCORE_MAP.getOrDefault(playerBScore, "40"));
    }

    public boolean isGameOver() {
        return gameOver;
    }
}