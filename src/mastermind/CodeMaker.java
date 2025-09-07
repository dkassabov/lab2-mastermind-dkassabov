package mastermind;

public class CodeMaker {
    private String secretCode;

    public CodeMaker(String secretCode) {
        this.secretCode = secretCode;
    }

    public void checkGuess(Guess guess) {
        int wrongPositions = 0;
        int correctPositions = 0;
        for (int i = 0; i < 4; i++) {
            if (guess.getGuess().charAt(i) == getSecretCode().charAt(i))
                correctPositions++;
            for (int j = 0; j < 4; j++) {
                
            }
        }
    }

    public String getSecretCode() {

        return secretCode;
    }
}
