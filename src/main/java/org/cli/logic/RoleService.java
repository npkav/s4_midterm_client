package org.cli.logic;

import org.cli.util.API_Client;

public class RoleService {
    
    public static void getAllRoles() {
        String response = API_Client.get("/roles");
        System.out.println("VIEWING ALL ROLES:");
        System.out.println(response);
    }

    public static void getAllDepartments() {
        String response = API_Client.get("/departments");
        System.out.println("VIEWING ALL DEPARTMENTS:");
        System.out.println(response);
    }

    public static void getRepsByRole(Long roleID) {
        String response = API_Client.get("/roles/" + roleID + "/reps");
        System.out.println("VIEWING REPS UNDER ROLE ID: " + roleID);
        System.out.println(response);
    }

    public static void getRepsByDepartment(Long departmentID) {
        String response = API_Client.get("/departments/" + departmentID + "/reps");
        System.out.println("VIEWING REPS UNDER DEPARTMENT ID: " + departmentID);
        System.out.println(response);
    }
}
