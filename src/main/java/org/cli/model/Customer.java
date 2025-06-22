// sample for Customer class before database is implemented

package org.cli.model;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Customer(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email;
    }
}
