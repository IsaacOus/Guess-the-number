package org.esgi.al.ex2;

import java.util.Scanner;

public class Parser {

    private final Scanner scanner;

    public Parser() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

}
