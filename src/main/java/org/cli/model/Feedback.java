package org.cli.model;

public class Feedback {
    private Long id;
    private Long customerID;
    private Long repID;
    private Long issueID;
    private Integer rating;
    private String comment;

    public Feedback() {}

    public Feedback(Long id, Long customerID, Long repID, Long issueID, Integer rating, String comment) {
        this.id = id;
        this.customerID = customerID;
        this.repID = repID;
        this.issueID = issueID;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }

    public Long getCustomerID() { return customerID; }
    public void setCustomerID(Long customerID) { this.customerID = customerID; }

    public Long getRepID() { return repID; }
    public void setRepID(Long repID) { this.repID = repID; }

    public Long getIssueID() { return issueID; }
    public void setIssueID(Long issueID) { this.issueID = issueID; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    @Override
    public String toString() {
        return "Feedback ID: " + id + ", Rating: " + rating + "/5, Customer ID: " + customerID + 
        ", Rep ID: " + repID + ", Comment: " + comment;
    }
} 