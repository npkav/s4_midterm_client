package org.cli.logic;

import org.cli.util.API_Client;

public class RepService {

    public static void viewAllReps() {
        String response = API_Client.get("/servicereps");
        System.out.println("VIEWING ALL SERVICE REPS:");
        System.out.println(response);
    }

    public static void viewIssuesForRep(Long repID) {
        String response = API_Client.get("/servicereps/" + repID + "/issues");
        System.out.println("VIEWING ALL ISSUES FOR REP " + repID + ":");
        System.out.println(response);
    }

    public static void getAllDepartments() {
        String response = API_Client.get("/departments");
        System.out.println("Available departments:");
        System.out.println(response);
    }

    public static void getAllRoles() {
        String response = API_Client.get("/roles");
        System.out.println("Available roles:");
        System.out.println(response);
    }

    public static void filterRepsByDepartment(Long departmentId) {
        String response = API_Client.get("/servicereps/filter?departmentID=" + departmentId);
        System.out.println("VIEWING ALL REPS BY DEPARTMENT ID " + departmentId + ":");
        System.out.println(response);
    }

    public static void filterRepsByRole(Long roleId) {
        String response = API_Client.get("/servicereps/filter?roleID=" + roleId);
        System.out.println("VIEWING ALL REPS BY ROLE ID " + roleId + ":");
        System.out.println(response);
    }

    public static void filterRepsByDepartmentAndRole(Long departmentId, Long roleId) {
        String response = API_Client.get("/servicereps/filter?departmentID=" + departmentId + "&roleID=" + roleId);
        System.out.println("VIEWING ALL REPS BY DEPARTMENT ID " + departmentId + " AND ROLE ID " + roleId + ":");
        System.out.println(response);
    }

    public static void searchRepByName(String name) {
        String response = API_Client.get("/servicereps/search?name=" + name);
        System.out.println("SEARCHING FOR REPS WITH NAME: " + name);
        System.out.println(response);
    }
}