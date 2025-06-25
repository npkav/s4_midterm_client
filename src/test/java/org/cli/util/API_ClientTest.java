package org.cli.util;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class API_ClientTest {

    private final HttpClient mockHttpClient = mock(HttpClient.class);

    @Test
    void testGetSuccessfulRequest() throws IOException {
        String expectedResponse = "{\"data\": \"test\"}";
        when(mockHttpClient.get(anyString())).thenReturn(expectedResponse);
        
        API_Client.setHttpClient(mockHttpClient);
        String response = API_Client.get("/test");
        
        assertEquals(expectedResponse, response);
    }

    @Test
    void testGetWithError() throws IOException {
        String errorMessage = "Connection refused";
        when(mockHttpClient.get(anyString())).thenThrow(new IOException(errorMessage));
        
        API_Client.setHttpClient(mockHttpClient);
        String response = API_Client.get("/test");
        
        assertEquals("ERROR: " + errorMessage, response);
    }

    @Test
    void testGetWithNullEndpoint() {
        API_Client.setHttpClient(mockHttpClient);
        String response = API_Client.get(null);
        
        assertEquals("ERROR: Endpoint cannot be null", response);
    }

    @Test
    void testGetWithInvalidEndpoint() throws IOException {
        String errorMessage = "Invalid endpoint";
        when(mockHttpClient.get(anyString())).thenThrow(new IOException(errorMessage));
        
        API_Client.setHttpClient(mockHttpClient);
        String response = API_Client.get("invalid\\endpoint");
        
        assertEquals("ERROR: " + errorMessage, response);
    }
}
