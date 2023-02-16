package org.esgi.al.ex2;

import java.util.Random;

public class NumberToGuess {
    private final int number;

    public NumberToGuess() {
        Random random = new Random();
        number = random.nextInt(100) + 1;
    }

    public int getNumber() {
        return number;
    }


    public boolean isCorrect(int userGuess) {
        return userGuess == number;
    }
}
