package mastermind;

public class Guess {
    private static int currentGuessNumber = 1;
    private String guess;
    private int guessNumber, correctPositions, wrongPositions;

    public Guess(String guess) {
        this.guess = guess;
        guessNumber = currentGuessNumber;
        currentGuessNumber++;
    }

    public int getCorrectPositions() {
        return correctPositions;
    }

    public void setCorrectPositions(int correctPositions) {
        this.correctPositions = correctPositions;
    }

    public String getGuess() {
        return guess;
    }

    public int getWrongPositions() {
        return wrongPositions;
    }

    public void setWrongPositions(int wrongPositions) {
        this.wrongPositions = wrongPositions;
    }

    @Override
    public String toString() {
        return "Guess #" + guessNumber + ": " + guess + " (B:" + correctPositions + " W:" + wrongPositions + ")";
    }

}
