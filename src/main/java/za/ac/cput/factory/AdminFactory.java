package za.ac.cput.factory;

import za.ac.cput.entity.Admin;

/* AdminFactory.java
   Admin Factory Class
   Author: Paul Khumalo (230108547)
   Date: 21 June 2026
*/

public class AdminFactory {
    private AdminFactory() {}

    public static Admin create(String adminId, String role, String permissions) {
        return Admin.builder()
                .adminId(adminId)
                .role(role)
                .permissions(permissions)
                .build();
    }
}
