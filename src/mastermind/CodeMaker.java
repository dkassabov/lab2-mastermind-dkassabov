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
    private String secretCode;

    public CodeMaker(String secretCode) {
        this.secretCode = secretCode;
    }

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

    public String getSecretCode() {

        return secretCode;
    }
}
