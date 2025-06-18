package org.cli.menu;

import org.cli.util.InputHelper;

public class CustomerMenu {
    public static void show() {
        System.out.println("\n--- You have selected: View Customers & Issues Reported ---");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. View all customers");
            System.out.println("2. View all issues");
            System.out.println("3. View issues reported by a specific customer");
            System.out.println("4. Search customer by name");
            System.out.println("5. Return to main menu");

            int choice = InputHelper.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> System.out.println("Viewing all customers..."); // TODO: Implement logic to view all customers
                case 2 -> System.out.println("Viewing all issues..."); // TODO: Implement logic to view all issues
                case 3 -> System.out.println("Viewing issues by customer..."); // TODO: Implement logic to view issues by a specific customer
                case 4 -> System.out.println("Searching customer by name..."); // TODO: Implement logic to search customer by name
                case 5 -> { return; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
