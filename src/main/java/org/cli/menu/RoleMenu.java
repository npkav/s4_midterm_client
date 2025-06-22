package org.cli.menu;

import org.cli.util.InputHelper;

public class RoleMenu {
    public static void show() {
        System.out.println("\n--- You have selected: View Roles/Departments ---");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. View all roles");
            System.out.println("2. View all departments");
            System.out.println("3. View all reps under a specific role");
            System.out.println("4. View all reps under a specific department");
            System.out.println("5. Return to main menu");

            int choice = InputHelper.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> System.out.println("Viewing all roles..."); // TODO: Implement logic to list all roles
                case 2 -> System.out.println("Viewing all departments..."); // TODO: Implement logic to list all departments
                case 3 -> System.out.println("Viewing reps under a role..."); // TODO: Implement logic to list reps under a specific role
                case 4 -> System.out.println("Viewing reps under a department..."); // TODO: Implement logic to list reps in a specific department
                case 5 -> { return; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
