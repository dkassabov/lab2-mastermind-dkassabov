package mastermind;

import java.util.Scanner;

/**
 * The CodeBreaker is the one who creates a valid Guess upon checking the
 * validity of user input. It also stores the intermediate score value during
 * a game run.
 *
 * @author Denis Kassabov
 */

public class CodeBreaker {
    /** Character that ends the game if entered */
    private static final char QUIT = 'q';
    /** Scanner for reading input */
    private Scanner in;
    /** The accumulated score for this CodeBreaker */
    int score;

    /**
     * Construct a new CodeBreaker with a fresh score counter.
     */
    public CodeBreaker() {
        in = new Scanner(System.in);
    }

    /**
     * Increase the CodeBreaker's score.
     *
     * @param amount the amount to add
     */
    public void increaseScore(int amount) {
        score += amount;
    }

    /**
     * Get the current score.
     *
     * @return current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Prompt the user for a valid guess until one is entered.
     * Returns null if the user enters 'q' to quit.
     *
     * @return a new valid {@link Guess}, or null if quitting
     */
    public Guess getGuess() {
        while (true) {
            System.out.print("? ");
            String input = in.nextLine().trim();

            // Quit case
            if (input.equals(Character.toString(QUIT))) return null;

            if (!isValidLength(input)) {
                System.out.println("Guess must have 4 digits!");
                continue;
            }
            if (!isValidDigits(input)) {
                System.out.println("Guess must have all digits between 1 and 8!");
                continue;
            }
            if (!isUniqueDigits(input)) {
                System.out.println("Guess cannot have duplicate digits!");
                continue;
            }

            return new Guess(input);
        }
    }

    // Private helper methods for getGuess()

    /**
     * Check that the input has the correct length.
     *
     * @param input the input string
     * @return true if valid length, false otherwise
     */
    private boolean isValidLength(String input) {
        return input.length() == 4;
    }

    /**
     * Check that all characters are digits between 1 and 8.
     *
     * @param input the input string
     * @return true if all digits are valid, false otherwise.
     */
    private boolean isValidDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            int nextDigit = Character.getNumericValue(input.charAt(i));
            if (nextDigit < 1 || nextDigit > 8) return false;
        }
        return true;
    }

    /**
     * Check that there are no duplicate digits.
     *
     * @param input the input string
     * @return true if all digits are unique, false otherwise
     */
    private boolean isUniqueDigits(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            int compared = Character.getNumericValue(input.charAt(i));
            for (int j = i+1; j < input.length(); j++) {
                int compared2 = Character.getNumericValue(input.charAt(j));
                if (compared == compared2)
                    return false;
            }
        }
        return true;
    }
}