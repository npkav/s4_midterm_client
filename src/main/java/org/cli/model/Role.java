package org.cli.model;

public class Role {
    private Long id;
    private String name;
    private String description;
    private Long departmentID;

    public Role() {}

    public Role(Long id, String name, String description, Long departmentID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.departmentID = departmentID;
    }

    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getDepartmentID() { return departmentID; }
    public void setDepartmentID(Long departmentID) { this.departmentID = departmentID; }

    @Override
    public String toString() {
        return "Role ID: " + id + ", Name: " + name + ", Department ID: " + departmentID + 
               (description != null ? ", Description: " + description : "");
    }
}
