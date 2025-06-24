package org.cli.model;

public class Department {
    private Long id;
    private String name;
    private String description;

    public Department() {}

    public Department(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Department ID: " + id + ", Name: " + name + 
               (description != null ? ", Description: " + description : "");
    }
}
