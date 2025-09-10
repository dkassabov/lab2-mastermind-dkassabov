package mastermind;

import java.util.Arrays;

/**
 * The main class for the Mastermind game.  The secret code can be provided
 * as the command line argument, otherwise it will be randomly generated.
 *
 * @author RIT CS
 * @author Denis Kassabov
 */

public class MasterMind {
    /** the number of digits in the secret code */
    public final static int SECRET_CODE_LENGTH = 4;
    /** the minimum digit in the code */
    public final static int MIN_CODE_DIGIT = 1;
    /** the maximum digit in the code */
    public final static int MAX_CODE_DIGIT = 8;
    /** the number of turns in the game */
    private final static int MAX_TURNS = 10;

    private CodeMaker codeMaker;
    private CodeBreaker codeBreaker;
    private Guesses guesses;

    public MasterMind(String secretCode) {
        codeMaker = new CodeMaker(secretCode);
        codeBreaker = new CodeBreaker();
        guesses = new Guesses();
    }

    /**
     * Check that the digits in a code are all in the valid range.
     *
     * @param code the code to check
     * @rit.pre code is of the correct length
     * @return whether the code is valid or not
     */
    public static boolean codeInRange(String code) {
        for (int i = 0; i < code.length(); ++i) {
            if (Character.getNumericValue(code.charAt(i)) < MIN_CODE_DIGIT ||
                    Character.getNumericValue(code.charAt(i)) > MAX_CODE_DIGIT) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check that there are no duplicates in the code.
     * @param code the code to check
     * @rit.pre code is of the correct length
     * @rit.pre code has all digits in valid range
     * @return whether the code has no duplicates (true) or does haveduplicates (false)
     */
    public static boolean codeNoDuplicates(String code) {
        return code.length() == code.chars().distinct().count();
    }

    public void playGame() {

        boolean gameWon = false;
        boolean quit = false;
        int turns = 1;
        Guess guess;

        System.out.println("Welcome to MasterMind!");
        System.out.println("Enter your 4-digit guesses (q to quit)");

        // Until the game is either won or the number of turns has been exhausted
        while (!gameWon && turns <= MAX_TURNS) {
            // Get the next validly formatted Guess from the CodeBreaker
            guess = codeBreaker.getGuess();
            if (guess == null) {
                quit = true;
                System.out.println("Quitting...");
                break;
            }

            // Pass the Guess to the CodeMaker for checking
            codeMaker.checkGuess(guess);

            // Add the Guess to the Guesses and display them
            guesses.addGuess(guess);
            guesses.displayGuesses();

            // Adjust the CodeBreaker's score based on this game
            codeBreaker.increaseScore(guess.getCorrectPositions() * 2
                    + guess.getWrongPositions());

            // Check if the CodeMaker's secret code has been cracked or not
            // (also based on the guess)
            if (guess.getCorrectPositions() == SECRET_CODE_LENGTH) {
                gameWon = true;
            }
            else turns++;

        }

        if (gameWon) {
            System.out.println("You won!");
        }
        else if (turns > MAX_TURNS) {
            System.out.println("You lost! The secret code was: "
                    + codeMaker.getSecretCode());
        }

        if (!quit) {
            if (turns > MAX_TURNS) {
                turns--;
            }
            System.out.println("Code breaker score: "
                    + (double) codeBreaker.getScore() / turns);
        }
    }

    /**
     * The main method verifies the command line code (if present) and
     * then plays the game.
     *
     * @param args command line arguments (the secret number, optionally)
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Mastermind secret-number");
            return;
        } else {
            if (args[0].length() != SECRET_CODE_LENGTH) {
                System.out.println("Secret number " + args[0] +
                        " is not length " + SECRET_CODE_LENGTH);
                return;
            } else if (!codeInRange(args[0])) {
                System.out.println("Secret number " + args[0] +
                        " is invalid.  Expect all digits to be between " +
                        MIN_CODE_DIGIT + " and " +
                        MAX_CODE_DIGIT);
                return;
            } else if (!codeNoDuplicates(args[0])) {
                System.out.println("Secret number " + args[0] +
                        " is invalid.  Has duplicate digits.");
                return;
            }
        }

        // TODO - Everything is okay to play the game if we got here
        MasterMind masterMind = new MasterMind(args[0]);
        masterMind.playGame();
    }
}
