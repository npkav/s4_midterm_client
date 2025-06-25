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

class CustomerServiceTest {
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
    void testGetAllCustomers() {
        String mockResponse = "[{\"id\":1,\"name\":\"John Doe\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/customer"))
                    .thenReturn(mockResponse);

            CustomerService.getAllCustomers();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING ALL CUSTOMERS:"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testSearchByName() {
        String name = "John";
        String mockResponse = "[{\"id\":1,\"name\":\"John Doe\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/customer/search?name=" + name))
                    .thenReturn(mockResponse);

            CustomerService.searchByName(name);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("SEARCH RESULTS:"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetAllCustomersWithError() {
        String errorMessage = "Connection refused";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/customer"))
                    .thenReturn("ERROR: " + errorMessage);

            CustomerService.getAllCustomers();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("ERROR: " + errorMessage));
        }
    }
}
