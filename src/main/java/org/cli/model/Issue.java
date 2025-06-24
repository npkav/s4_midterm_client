package org.cli.model;

public class Issue {
    private Long id;
    private Long customerID;
    private Long assignedRepID;
    private String title;
    private String description;
    private String status;
    private String priority;

    public Issue() {}

    public Issue(Long id, Long customerID, Long assignedRepID, String title, String description, String status, String priority) {
        this.id = id;
        this.customerID = customerID;
        this.assignedRepID = assignedRepID;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }

    public Long getCustomerID() { return customerID; }
    public void setCustomerID(Long customerID) { this.customerID = customerID; }

    public Long getAssignedRepID() { return assignedRepID; }
    public void setAssignedRepID(Long assignedRepID) { this.assignedRepID = assignedRepID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    @Override
    public String toString() {
        return "Issue ID: " + id + ", Title: " + title + ", Priority: " + priority + 
        ", Status: " + status + ", Customer ID: " + customerID + ", Rep ID: " + assignedRepID;
    }
} 