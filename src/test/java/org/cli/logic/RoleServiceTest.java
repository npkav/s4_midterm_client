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

class RoleServiceTest {
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
    void testGetAllRoles() {
        String mockResponse = "[{\"id\":1,\"title\":\"Manager\"},{\"id\":2,\"title\":\"Agent\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/roles"))
                    .thenReturn(mockResponse);

            RoleService.getAllRoles();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING ALL ROLES:"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetAllDepartments() {
        String mockResponse = "[{\"id\":1,\"name\":\"Support\"},{\"id\":2,\"name\":\"Sales\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/departments"))
                    .thenReturn(mockResponse);

            RoleService.getAllDepartments();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING ALL DEPARTMENTS:"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetRepsByRole() {
        Long roleId = 1L;
        String mockResponse = "[{\"id\":1,\"name\":\"Jane Smith\",\"roleID\":1}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/roles/" + roleId + "/reps"))
                    .thenReturn(mockResponse);

            RoleService.getRepsByRole(roleId);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING REPS UNDER ROLE ID: " + roleId));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetRepsByDepartment() {
        Long deptId = 1L;
        String mockResponse = "[{\"id\":1,\"name\":\"Jane Smith\",\"departmentID\":1}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/departments/" + deptId + "/reps"))
                    .thenReturn(mockResponse);

            RoleService.getRepsByDepartment(deptId);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING REPS UNDER DEPARTMENT ID: " + deptId));
            assertTrue(output.contains(mockResponse));
        }
    }
    
    @Test
    void testGetAllRolesWithError() {
        String errorMsg = "Server not available";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/roles"))
                    .thenReturn("ERROR: " + errorMsg);

            RoleService.getAllRoles();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("ERROR: " + errorMsg));
        }
    }
}
