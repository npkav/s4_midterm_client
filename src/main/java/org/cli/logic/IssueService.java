package org.cli.logic;

import org.cli.util.API_Client;
import org.cli.util.InputHelper;

public class IssueService {
    
    public static void getAllIssues() {
        String response = API_Client.get("/issues");
        System.out.println("ALL ISSUES:");
        System.out.println(response);
    }

    public static void getIssuesByCustomer(Long customerID) {
        String response = API_Client.get("/issues/customer/" + customerID);
        System.out.println("ISSUES FOR CUSTOMER ID: " + customerID);
        System.out.println(response);
    }

    public static void createIssue() {
        System.out.println("\nCREATE ISSUE:");
        Long customerID = InputHelper.getLongInput("CUSTOMER ID: ");
        String title = InputHelper.getStringInput("ISSUE TITLE: ");
        String description = InputHelper.getStringInput("ISSUE DESCRIPTION: ");
        String priority = InputHelper.getStringInput("ISSUE PRIORITY: ");
        if (priority.equalsIgnoreCase("high")) {priority = "HIGH";}
        else if (priority.equalsIgnoreCase("medium")) {priority = "MEDIUM";}
        else if (priority.equalsIgnoreCase("low")) {priority = "LOW";}
        else {priority = "INVALID PRIORITY: " + priority; return;}

        String json = String.format("{\"customerID\":%d,\"title\":\"%s\",\"description\":\"%s\",\"status\":\"Open\",\"priority\":\"%s\"}",
                                    customerID, title, description, priority);
        System.out.println(json);

        String response = API_Client.post("/issues", json);
        System.out.println("ISSUE CREATED:");
        System.out.println(response);
    }
} 