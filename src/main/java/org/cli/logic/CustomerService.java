package org.cli.logic;

import org.cli.util.API_Client;

public class CustomerService {
    
    public static void getAllCustomers() {
        String response = API_Client.get("/customer");
        System.out.println("VIEWING ALL CUSTOMERS:");
        System.out.println(response);
    }

    public static void searchByName(String name) {
        String response = API_Client.get("/customer/search?name=" + name);
        System.out.println("SEARCH RESULTS:");
        System.out.println(response);
    }
}