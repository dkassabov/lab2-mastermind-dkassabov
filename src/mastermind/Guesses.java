package mastermind;

import java.util.ArrayList;

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
