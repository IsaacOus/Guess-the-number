package org.esgi.al.ex2;

public class Attempt {

    private final int maxAttempts;

    private int attemptsLeft;

    public Attempt(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.attemptsLeft = maxAttempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public void decrementAttemptsLeft() {
        attemptsLeft--;
    }
}
