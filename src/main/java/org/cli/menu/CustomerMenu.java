package org.cli.menu;

import java.util.List;

import org.cli.logic.CustomerService;
import org.cli.model.Customer;
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
                case 1 -> {
                    List<Customer> customers = CustomerService.getAllCustomers();
                        if (customers.isEmpty()) {
                            System.out.println("No customers found.");
                        } else {
                            for (Customer c : customers) {
                                System.out.println(c);
                            }
                        }
                    }
                case 2 -> System.out.println("Viewing all issues..."); // TODO: Implement logic to view all issues
                case 3 -> System.out.println("Viewing issues by customer..."); // TODO: Implement logic to view issues by a specific customer
                case 4 -> {
                    String name = InputHelper.getStringInput("Enter customer name to search: ");
                    List<Customer> results = CustomerService.searchByName(name);

                    if (results.isEmpty()) {
                        System.out.println("No customers found matching \"" + name + "\".");
                    } else {
                        System.out.println("Matching customers:");
                        for (Customer c : results) {
                            System.out.println(c);
                        }
                    }
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
