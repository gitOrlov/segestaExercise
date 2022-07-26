package com.orlov;

import java.util.Scanner;

class Answer {
    private Scanner scanner = new Scanner(System.in);

    private static final String YES = "да";
    private static final String NO = "нет";

    private String answer;

    void readAnswer() {
        do {
            answer = scanner.nextLine();
        } while (!YES.equalsIgnoreCase(answer) && !NO.equalsIgnoreCase(answer));
    }

    String readString() {
        return scanner.nextLine();
    }

    boolean isPositive() {
        return YES.equalsIgnoreCase(answer);
    }
}
