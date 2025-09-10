package mastermind;

import java.util.Scanner;

public class CodeBreaker {
    private static final char QUIT = 'q';
    private Scanner in;
    int score;

    public CodeBreaker() {
        in = new Scanner(System.in);
    }

    public void increaseScore(int amount) {
        score += amount;
    }

    public int getScore() {
        return score;
    }

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
    private boolean isValidLength(String input) {
        return input.length() == 4;
    }

    private boolean isValidDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            int nextDigit = Character.getNumericValue(input.charAt(i));
            if (nextDigit < 1 || nextDigit > 8) return false;
        }
        return true;
    }

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