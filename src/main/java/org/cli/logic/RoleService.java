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

    public static void getRepsByRole(String role) {
        String response = API_Client.get("/reps/role?role=" + role);
        System.out.println("VIEWING REPS UNDER ROLE: " + role);
        System.out.println(response);
    }

    public static void getRepsByDepartment(String department) {
        String response = API_Client.get("/reps/department?department=" + department);
        System.out.println("VIEWING REPS UNDER DEPARTMENT: " + department);
        System.out.println(response);
    }
}
