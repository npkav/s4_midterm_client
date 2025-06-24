package org.cli.util;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline
        return input;
    }

    public static Long getLongInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextLong()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        Long input = scanner.nextLong();
        scanner.nextLine(); // consume leftover newline
        return input;
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
