package mastermind;

import java.util.ArrayList;

/**
 * This class stores a list of Guess objects that can be added and displayed
 * to standard output. It stores the Guess's in the order they are added.
 *
 * @author RIT CS
 * @author Denis Kassabov
 */

public class Guesses {
    /** Ordered list of guesses made so far */
    ArrayList<Guess> guessList;

    /**
     * Construct a new empty list of guesses.
     */
    public Guesses() {
        guessList = new ArrayList<>();
    }

    /**
     * Add a new guess to the list.
     *
     * @param guess the guess to add
     */
    public void addGuess(Guess guess) {
        guessList.add(guess);
    }

    /**
     * Display all guesses so far to standard output.
     * Each guess is printed on its own line.
     */
    public void displayGuesses() {
        for (int i = 0; i < guessList.size(); i++) {
            System.out.println(guessList.get(i).toString());
        }
    }

}
