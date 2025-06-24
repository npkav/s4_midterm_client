package org.cli.model;

public class Representative {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long roleID;
    private Long departmentID;

    public Representative() {}

    public Representative(Long id, String firstName, String lastName, String email, 
                         Long roleID, Long departmentID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleID = roleID;
        this.departmentID = departmentID;
    }

    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getRoleID() { return roleID; }
    public void setRoleID(Long roleID) { this.roleID = roleID; }

    public Long getDepartmentID() { return departmentID; }
    public void setDepartmentID(Long departmentID) { this.departmentID = departmentID; }

    @Override
    public String toString() {
        return "Rep ID: " + id + ", Name: " + firstName + " " + lastName + 
               ", Role ID: " + roleID + ", Department ID: " + departmentID + 
               ", Email: " + email;
    }
}
