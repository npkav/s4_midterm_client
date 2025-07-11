package org.cli.model;

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public Customer() {}

    public Customer(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email;
    }
}
