package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

/* AdminFactory.java
   Admin Factory Class
   Author: Paul Khumalo (230108547)
   Date: 21 June 2026
*/

public class AdminFactory {

    private AdminFactory() {
    }

    public static Admin createAdmin(String adminId,
                                    String role,
                                    String permissions) {

        if (Helper.isNullOrEmpty(adminId)) {
            throw new IllegalArgumentException("Admin system identity authorization key required");
        }

        if (Helper.isNullOrEmpty(role)) {
            throw new IllegalArgumentException("Admin role is required");
        }

        if (Helper.isNullOrEmpty(permissions)) {
            throw new IllegalArgumentException("Admin permissions are required");
        }

        return new Admin.Builder()
                .setAdminId(adminId)
                .setRole(role)
                .setPermissions(permissions)
                .build();
    }
}