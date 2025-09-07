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
    ArrayList<Guess> guessList;

    public Guesses() {
        guessList = new ArrayList<>();
    }

    public void addGuess(Guess guess) {
        guessList.add(guess);
    }

    public void displayGuesses() {
        for (int i = 0; i < guessList.size(); i++) {
            System.out.println(guessList.get(i).toString());
        }
    }

}
