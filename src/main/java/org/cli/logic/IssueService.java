package org.cli.logic;

import org.cli.util.API_Client;

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
} 