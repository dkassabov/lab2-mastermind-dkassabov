package mastermind;

/**
 * Represents a single codeword guess in the Mastermind game.
 * The CodeBreaker makes the new Guess and the CodeMaker checks it.
 *
 * @author RIT CS
 * @author Denis Kassabov
 */

public class Guess {
    /** The global counter for numbering guesses */
    private static int currentGuessNumber = 1;
    /** The 4-digit string value of this guess */
    private String guess;
    /** The number assigned to this guess (starting at 1) */
    private int guessNumber;
    /** Number of digits guessed in the correct position */
    int correctPositions;
    /** Number of digits guessed correctly but in wrong positions */
    int wrongPositions;

    /**
     * Construct a new Guess with a String value.
     *
     * @param guess the 4-digit guess String
     */
    public Guess(String guess) {
        this.guess = guess;
        guessNumber = currentGuessNumber;
        currentGuessNumber++;
    }

    /**
     * Get the number of correct positions.
     *
     * @return number of digits correct and in the right position
     */
    public int getCorrectPositions() {
        return correctPositions;
    }

    /**
     * Set the number of correct positions for this guess.
     *
     * @param correctPositions number of correct positions
     */
    public void setCorrectPositions(int correctPositions) {
        this.correctPositions = correctPositions;
    }

    /**
     * Get the string value of this guess.
     *
     * @return the guess string
     */
    public String getGuess() {
        return guess;
    }

    /**
     * Get the number of wrong positions.
     *
     * @return number of correct digits but wrong positions
     */
    public int getWrongPositions() {
        return wrongPositions;
    }

    /**
     * Set the number of wrong positions for this guess.
     *
     * @param wrongPositions number of correct digits in wrong positions
     */
    public void setWrongPositions(int wrongPositions) {
        this.wrongPositions = wrongPositions;
    }

    /**
     * String representation of the guess with statistics.
     *
     * @return a string like "Guess #1: 1234 (B:2 W:1)"
     */
    @Override
    public String toString() {
        return "Guess #" + guessNumber + ": " + guess + " (B:" + correctPositions + " W:" + wrongPositions + ")";
    }

}
