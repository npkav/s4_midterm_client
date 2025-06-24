package org.cli.menu;

import org.cli.logic.FeedbackService;
import org.cli.util.InputHelper;

public class FeedbackMenu {
    public static void show() {
        System.out.println("\n--- You have selected: View Customer Feedback & Ratings ---");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. View all feedback entries");
            System.out.println("2. View ratings for a specific rep");
            System.out.println("3. View average score for a specific rep");
            System.out.println("4. Filter feedback by rating (1-5)");
            System.out.println("5. Return to main menu");

            int choice = InputHelper.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> FeedbackService.getAllFeedback();
                case 2 -> {
                    int repID = InputHelper.getIntInput("Please enter the rep's ID: ");
                    FeedbackService.getFeedbackByRep((long) repID);
                }
                case 3 -> {
                    int repID = InputHelper.getIntInput("Please enter the rep's ID: ");
                    FeedbackService.getAverageRatingByRep((long) repID);
                }
                case 4 -> {
                    int rating = InputHelper.getIntInput("Enter rating (1-5): ");
                    FeedbackService.getFeedbackByRating(rating);
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
