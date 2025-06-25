package org.cli.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IssueTest {

    @Test
    void testIssueConstructorAndGetters() {
        Issue issue = new Issue(1L, 2L, 3L, "Test Issue", "Description", "Open", "High");
        
        assertEquals(1L, issue.getID());
        assertEquals(2L, issue.getCustomerID());
        assertEquals(3L, issue.getAssignedRepID());
        assertEquals("Test Issue", issue.getTitle());
        assertEquals("Description", issue.getDescription());
        assertEquals("Open", issue.getStatus());
        assertEquals("High", issue.getPriority());
    }

    @Test
    void testIssueSetters() {
        Issue issue = new Issue();
        
        issue.setID(1L);
        issue.setCustomerID(2L);
        issue.setAssignedRepID(3L);
        issue.setTitle("Test Issue");
        issue.setDescription("Description");
        issue.setStatus("Open");
        issue.setPriority("High");
        
        assertEquals(1L, issue.getID());
        assertEquals(2L, issue.getCustomerID());
        assertEquals(3L, issue.getAssignedRepID());
        assertEquals("Test Issue", issue.getTitle());
        assertEquals("Description", issue.getDescription());
        assertEquals("Open", issue.getStatus());
        assertEquals("High", issue.getPriority());
    }

    @Test
    void testToString() {
        Issue issue = new Issue(1L, 2L, 3L, "Test Issue", "Description", "Open", "High");
        String expected = "Issue ID: 1, Title: Test Issue, Priority: High, Status: Open, Customer ID: 2, Rep ID: 3";
        assertEquals(expected, issue.toString());
    }

    @Test
    void testEmptyConstructor() {
        Issue issue = new Issue();
        assertNull(issue.getID());
        assertNull(issue.getCustomerID());
        assertNull(issue.getAssignedRepID());
        assertNull(issue.getTitle());
        assertNull(issue.getDescription());
        assertNull(issue.getStatus());
        assertNull(issue.getPriority());
    }
}
