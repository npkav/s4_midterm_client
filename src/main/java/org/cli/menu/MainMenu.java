package org.cli.menu;

import org.cli.util.InputHelper;

public class MainMenu {
     public static void show() {
        while (true) {
            System.out.println("\n===== Welcome to the Customer Issue Tracking CLI =====");
            System.out.println("Please select an option:");
            System.out.println("1. View all customers & issues reported");
            System.out.println("2. View all reps & assigned issues");
            System.out.println("3. View all feedback submitted by customers (with ratings)");
            System.out.println("4. View all roles/departments");
            System.out.println("5. Exit");

            int choice = InputHelper.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> CustomerMenu.show();
                case 2 -> RepMenu.show();
                case 3 -> FeedbackMenu.show();
                case 4 -> RoleMenu.show();
                case 5 -> {
                    System.out.println("Exiting the program...");
                    return;
                }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
