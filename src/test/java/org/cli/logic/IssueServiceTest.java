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

class IssueServiceTest {
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
    void testGetAllIssues() {
        String mockResponse = "[{\"id\":1,\"title\":\"Test Issue\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/issues"))
                    .thenReturn(mockResponse);

            IssueService.getAllIssues();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("ALL ISSUES:"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetIssuesByCustomer() {
        Long customerId = 1L;
        String mockResponse = "[{\"id\":1,\"title\":\"Customer Issue\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/issues/customer/" + customerId))
                    .thenReturn(mockResponse);

            IssueService.getIssuesByCustomer(customerId);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("ISSUES FOR CUSTOMER ID: " + customerId));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetAllIssuesWithError() {
        String errorMessage = "Connection refused";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/issues"))
                    .thenReturn("ERROR: " + errorMessage);

            IssueService.getAllIssues();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("ERROR: " + errorMessage));
        }
    }
}
