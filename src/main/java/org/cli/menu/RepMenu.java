package org.cli.menu;

import org.cli.util.InputHelper;

public class RepMenu {
    public static void show() {
        System.out.println("\n--- You have selected: View Reps & Assigned Issues ---");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. View all service reps");
            System.out.println("2. View all issues assigned to a specific rep");
            System.out.println("3. Filter reps by department/role");
            System.out.println("4. Search rep by name");
            System.out.println("5. Return to main menu");

            int choice = InputHelper.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> System.out.println("Viewing all service reps..."); // TODO: Implement logic to view all reps
                case 2 -> System.out.println("Viewing issues assigned to a rep..."); // TODO: Implement logic to view rep's issues
                case 3 -> System.out.println("Filtering reps by department/role..."); // TODO: Implement logic to filter by department/role
                case 4 -> System.out.println("Searching rep by name..."); // TODO: Implement search rep by name logic
                case 5 -> { return; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
