package org.cli.menu;

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
                case 1 -> System.out.println("Viewing all feedback entries..."); // TODO: Implement logic to view all feedback entires
                case 2 -> System.out.println("Viewing ratings for a specific rep..."); // TODO: Implement logic to view ratings for a specific rep
                case 3 -> System.out.println("Calculating average score..."); // TODO: Implement logic for average rating of a rep
                case 4 -> System.out.println("Filtering feedback by rating..."); // TODO: Implement feedback filter logic; i.e. filter by rating 1-5
                case 5 -> { return; }
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
}
