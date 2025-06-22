package org.cli.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.cli.model.Customer;

public class CustomerService {
    private static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Timothy", "Johnson", "timothy@example.com"));
        customers.add(new Customer(2, "Amelia", "Frederick", "amelia@example.com"));
        customers.add(new Customer(3, "Carl", "Brown", "carl@example.com"));
    }

    public static List<Customer> getAllCustomers() {
        return customers;
    }

    public static List<Customer> searchByName(String query) {
        String lowered = query.toLowerCase();
        return customers.stream()
                .filter(c ->
                        c.getFirstName().toLowerCase().contains(lowered) ||
                        c.getLastName().toLowerCase().contains(lowered) ||
                        (c.getFirstName() + " " + c.getLastName()).toLowerCase().contains(lowered)
                )
                .collect(Collectors.toList());
    }
}