package org.cli.menu;

import org.cli.logic.RepService;
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
                case 1 -> RepService.viewAllReps();
                case 2 -> {
                    int repID = InputHelper.getIntInput("Please enter the rep's ID: ");
                    RepService.viewIssuesForRep((long) repID);
                }
                case 3 -> {
                    System.out.println("What would you like to filter by?");
                    System.out.println("1) Department");
                    System.out.println("2) Role");
                    System.out.println("3) Both");
                    System.out.println("4) Cancel");
                    int filterChoice = InputHelper.getIntInput("Enter your choice: ");

                    switch (filterChoice) {
                        case 1 -> {
                            RepService.getAllDepartments();
                            int deptChoice = InputHelper.getIntInput("Please enter department ID: ");
                            RepService.filterRepsByDepartment((long) deptChoice);
                        }
                        case 2 -> {
                            RepService.getAllRoles();
                            int roleChoice = InputHelper.getIntInput("Please enter role ID: ");
                            RepService.filterRepsByRole((long) roleChoice);
                        }
                        case 3 -> {
                            RepService.getAllDepartments();
                            int deptChoice = InputHelper.getIntInput("Please enter department ID: ");
                            
                            RepService.getAllRoles();
                            int roleChoice = InputHelper.getIntInput("Please enter role ID: ");
                            
                            RepService.filterRepsByDepartmentAndRole((long) deptChoice, (long) roleChoice);
                        }
                        case 4 -> { return; }
                        default -> System.out.println("Invalid input, please try again.");
                    }
                }
                case 4 -> {
                    String repName = InputHelper.getStringInput("Enter rep name to search: ");
                    RepService.searchRepByName(repName);
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}