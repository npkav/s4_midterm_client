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

class RepServiceTest {
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
    void testViewAllReps() {
        String mockResponse = "[{\"id\":1,\"name\":\"Jane Smith\",\"departmentID\":2,\"roleID\":3}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/servicereps"))
                    .thenReturn(mockResponse);

            RepService.viewAllReps();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING ALL SERVICE REPS:"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testViewIssuesForRep() {
        Long repId = 1L;
        String mockResponse = "[{\"id\":1,\"title\":\"Customer Issue\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/servicereps/" + repId + "/issues"))
                    .thenReturn(mockResponse);

            RepService.viewIssuesForRep(repId);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING ALL ISSUES FOR REP " + repId + ":"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetAllDepartments() {
        String mockResponse = "[{\"id\":1,\"name\":\"Support\"},{\"id\":2,\"name\":\"Sales\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/departments"))
                    .thenReturn(mockResponse);

            RepService.getAllDepartments();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("Available departments:"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testGetAllRoles() {
        String mockResponse = "[{\"id\":1,\"title\":\"Manager\"},{\"id\":2,\"title\":\"Agent\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/roles"))
                    .thenReturn(mockResponse);

            RepService.getAllRoles();

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("Available roles:"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testFilterRepsByDepartment() {
        Long deptId = 1L;
        String mockResponse = "[{\"id\":1,\"name\":\"Jane Smith\",\"departmentID\":1}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/servicereps/filter?departmentID=" + deptId))
                    .thenReturn(mockResponse);

            RepService.filterRepsByDepartment(deptId);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING ALL REPS BY DEPARTMENT ID " + deptId + ":"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testFilterRepsByRole() {
        Long roleId = 2L;
        String mockResponse = "[{\"id\":1,\"name\":\"Jane Smith\",\"roleID\":2}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/servicereps/filter?roleID=" + roleId))
                    .thenReturn(mockResponse);

            RepService.filterRepsByRole(roleId);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING ALL REPS BY ROLE ID " + roleId + ":"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testFilterRepsByDepartmentAndRole() {
        Long deptId = 1L;
        Long roleId = 2L;
        String mockResponse = "[{\"id\":1,\"name\":\"Jane Smith\",\"departmentID\":1,\"roleID\":2}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/servicereps/filter?departmentID=" + deptId + "&roleID=" + roleId))
                    .thenReturn(mockResponse);

            RepService.filterRepsByDepartmentAndRole(deptId, roleId);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("VIEWING ALL REPS BY DEPARTMENT ID " + deptId + " AND ROLE ID " + roleId + ":"));
            assertTrue(output.contains(mockResponse));
        }
    }

    @Test
    void testSearchRepByName() {
        String name = "Jane";
        String mockResponse = "[{\"id\":1,\"name\":\"Jane Smith\"}]";
        
        try (MockedStatic<API_Client> mockedStatic = mockStatic(API_Client.class)) {
            mockedStatic.when(() -> API_Client.get("/servicereps/search?name=" + name))
                    .thenReturn(mockResponse);

            RepService.searchRepByName(name);

            String output = outputStreamCaptor.toString().trim();
            assertTrue(output.contains("SEARCHING FOR REPS WITH NAME: " + name));
            assertTrue(output.contains(mockResponse));
        }
    }
}
