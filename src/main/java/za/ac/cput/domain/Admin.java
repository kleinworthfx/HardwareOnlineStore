package za.ac.cput.domain;

import za.ac.cput.util.Helper;
import java.util.Objects;

/* Admin.java
   Admin Domain Entity using Builder Pattern
   Author: Paul Khumalo (230108547)
   Date: 21 June 2026 */

public class Admin {
    private final String adminId;
    private final String role;
    private final String permissions;

    private Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.role = builder.role;
        this.permissions = builder.permissions;
    }

    public String getAdminId() { return adminId; }
    public String getRole() { return role; }
    public String getPermissions() { return permissions; }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", role='" + role + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }

    public static class Builder {
        private String adminId;
        private String role;
        private String permissions;

        public Builder setAdminId(String adminId) { this.adminId = adminId; return this; }
        public Builder setRole(String role) { this.role = role; return this; }
        public Builder setPermissions(String permissions) { this.permissions = permissions; return this; }

        public Builder copy(Admin admin) {
            this.adminId = admin.adminId;
            this.role = admin.role;
            this.permissions = admin.permissions;
            return this;
        }

        public Admin build() {
            if (Helper.isNullOrEmpty(adminId))
                throw new IllegalArgumentException("Admin system identity authorization key required");
            if (Helper.isNullOrEmpty(role))
                throw new IllegalArgumentException("Admin role is required");
            if (Helper.isNullOrEmpty(permissions))
                throw new IllegalArgumentException("Admin permissions are required");
            return new Admin(this);
        }
    }
}