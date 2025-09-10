package mastermind;

/**
 * The CodeMaker is the one who creates or stores the secret code
 * and allows the CodeBreaker to make guesses that check against
 * the secret code.
 *
 * @author RIT CS
 * @author Denis Kassabov
 */

public class CodeMaker {
    /** The secret 4-digit code chosen by the CodeMaker */
    private String secretCode;

    /**
     * Construct a CodeMaker with a specific secret code.
     *
     * @param secretCode the 4-digit secret code
     */
    public CodeMaker(String secretCode) {
        this.secretCode = secretCode;
    }

    /**
     * Compare a guess against the secret code and update its number of
     * correct and wrong positions.
     *
     * @param guess the guess to evaluate
     */
    public void checkGuess(Guess guess) {
        int correctPositions = 0;
        int wrongPositions = 0;
        for (int i = 0; i < 4; i++) {
            // If correct color and position
            if (guess.getGuess().charAt(i) == secretCode.charAt(i)){
                correctPositions++;
                continue;
            }
            for (int j = 0; j < 4; j++) {
                // If correct color but wrong position
                if (guess.getGuess().charAt(i) == secretCode.charAt(j))
                    wrongPositions++;
            }
        }
        if (correctPositions != 0)
            guess.setCorrectPositions(correctPositions);
        if (wrongPositions != 0)
            guess.setWrongPositions(wrongPositions);
    }

    /**
     * Get the secret code.
     *
     * @return the secret code string.
     */
    public String getSecretCode() {

        return secretCode;
    }
}
