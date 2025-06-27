package org.cli.menu;

import org.cli.logic.CustomerService;
import org.cli.logic.IssueService;
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
            System.out.println("5. Compose Issue on Behalf of Customer");
            System.out.println("6. Return to main menu");

            int choice = InputHelper.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> CustomerService.getAllCustomers();
                case 2 -> IssueService.getAllIssues();
                case 3 -> {
                    Long customerID = InputHelper.getLongInput("Enter customer ID: ");
                    IssueService.getIssuesByCustomer(customerID);
                }
                case 4 -> {
                    String name = InputHelper.getStringInput("Enter customer name to search: ");
                    CustomerService.searchByName(name);
                }
                case 5 -> IssueService.createIssue();
                case 6 -> { return; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
