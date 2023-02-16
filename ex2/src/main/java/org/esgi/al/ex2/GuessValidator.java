package org.esgi.al.ex2;

public class GuessValidator {
    private String input;
    private String errorMessage;

    public GuessValidator(String input) {
        this.input = input;
    }

    public boolean isValid() {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            errorMessage = "Your input was '" + input + "', please enter a valid integer.";
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
