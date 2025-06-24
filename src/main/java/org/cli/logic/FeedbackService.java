package org.cli.logic;

import org.cli.util.API_Client;

public class FeedbackService {
    
    public static void getAllFeedback() {
        String response = API_Client.get("/feedback");
        System.out.println("VIEWING ALL FEEDBACK:");
        System.out.println(response);
    }

    public static void getFeedbackByRep(Long repID) {
        String response = API_Client.get("/feedback/rep/" + repID);
        System.out.println("FEEDBACK FOR REP ID: " + repID);
        System.out.println(response);
    }

    public static void getAverageRatingByRep(Long repID) {
        String response = API_Client.get("/feedback/rep/" + repID + "/average-rating");
        System.out.println("AVERAGE RATING FOR REP ID: " + repID);
        System.out.println(response);
    }

    public static void getFeedbackByRating(int rating) {
        String response = API_Client.get("/feedback/filter?rating=" + rating);
        System.out.println("FEEDBACK WITH " + rating + " STAR RATING:");
        System.out.println(response);
    }
} 