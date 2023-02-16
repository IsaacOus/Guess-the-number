package org.esgi.al.ex2;

import java.util.Scanner;

public class Game {
    private final Scanner scanner;

    private final Parser parser = new Parser();

    private NumberToGuess numberToGuess;

    private static final Logger logger = Logger.getInstance();


    private final Attempt attempt = new Attempt(10);

    public Game() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        logger.log("-===========================-");
        logger.log("=== GUESS THE NUMBER GAME ===");
        logger.log("-===========================-");

        boolean continuePlaying = true;

        while (continuePlaying) {
            numberToGuess = new NumberToGuess();

            logger.log("Guess the number (between 1 and 100)!");
            logger.log("debug : the expected number is " + numberToGuess.getNumber());

            while (!checkUserGuess()) {
                if (this.attempt.getAttemptsLeft() == 0) {
                    logger.log("You lose after " + this.attempt.getMaxAttempts() + " tries, the expected number was " + numberToGuess.getNumber());
                    break;
                }
            }

            logger.log("----------------------------------------------------");
            logger.log("Do you want to try again with a new number (yes/no)?");
            String userResponse = this.parser.getInput().trim().toLowerCase();
            continuePlaying = userResponse.equals("yes");
        }

        logger.log("== Thanks for playing! ==");
        scanner.close();
    }

    private boolean checkUserGuess() {
        attempt.decrementAttemptsLeft();
        String input = this.parser.getInput();
        try {
            int userGuess = Integer.parseInt(input);
            if (userGuess == numberToGuess.getNumber()) {
                logger.log("You found it after " + (this.attempt.getMaxAttempts() - this.attempt.getAttemptsLeft() + 1) + " tries!");
                return true;
            } else {
                String divergence = userGuess < numberToGuess.getNumber() ? "smaller" : "greater";
                logger.log("Wrong! Your number is " + divergence + " than the correct one. " + this.attempt.getAttemptsLeft() + "/" + this.attempt.getMaxAttempts() + " tries left");
            }
        } catch (NumberFormatException e) {
            logger.log("Your input was '" + input + "', please enter a valid integer. " + this.attempt.getAttemptsLeft() + "/" + this.attempt.getMaxAttempts() + " tries left");
        }
        return false;
    }

}

