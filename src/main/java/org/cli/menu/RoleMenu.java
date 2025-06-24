package org.cli.menu;

import org.cli.logic.RoleService;
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
                case 1 -> RoleService.getAllRoles();
                case 2 -> RoleService.getAllDepartments();
                case 3 -> {
                    int roleID = InputHelper.getIntInput("Please enter the role ID: ");
                    RoleService.getRepsByRole((long) roleID);
                }
                case 4 -> {
                    int departmentID = InputHelper.getIntInput("Please enter the department ID: ");
                    RoleService.getRepsByDepartment((long) departmentID);
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
