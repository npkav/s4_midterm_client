package org.cli.logic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.cli.util.API_Client;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mockStatic;

class FeedbackServiceTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testGetAllFeedback() {
        String mockResponse = "[{\"id\":1,\"rating\":5,\"comment\":\"Great service\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/feedback"))
                    .thenReturn(mockResponse);

            FeedbackService.getAllFeedback();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING ALL FEEDBACK:"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetFeedbackByRep() {
        Long repId = 1L;
        String mockResponse = "[{\"id\":1,\"rating\":5,\"comment\":\"Great service\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/feedback/rep/" + repId))
                    .thenReturn(mockResponse);

            FeedbackService.getFeedbackByRep(repId);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("FEEDBACK FOR REP ID: " + repId));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetAverageRatingByRep() {
        Long repId = 1L;
        String mockResponse = "4.8";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/feedback/rep/" + repId + "/average-rating"))
                    .thenReturn(mockResponse);

            FeedbackService.getAverageRatingByRep(repId);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("AVERAGE RATING FOR REP ID: " + repId));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetFeedbackByRating() {
        int rating = 5;
        String mockResponse = "[{\"id\":1,\"rating\":5,\"comment\":\"Great service\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/feedback/filter?rating=" + rating))
                    .thenReturn(mockResponse);

            FeedbackService.getFeedbackByRating(rating);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("FEEDBACK WITH " + rating + " STAR RATING:"));
            assertTrue(output.contains(mockResponse));
        }
    }
}
