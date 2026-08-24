package za.ac.cput.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;

import java.util.Objects;

/* Admin.java
   Admin Domain Entity using Builder Pattern
   Author: Paul Khumalo (230108547)
   Date: 21 June 2026 */

@Entity
@Table(name = "admin")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="admin_id", nullable=false, length=255, unique=true)
    private String adminId;
    @Column(nullable=false, length=255)
    private String role;
    @Column(nullable=false, length=255)
    private String permissions;
    @OneToOne(mappedBy = "admin", fetch = FetchType.LAZY)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Cart cart;

    protected Admin() {
    }

    private Admin(Builder builder) {
        this.id = builder.id;
        this.adminId = builder.adminId;
        this.role = builder.role;
        this.permissions = builder.permissions;
    }

    public Long getId() { return id; }
    public String getAdminId() { return adminId; }
    public String getRole() { return role; }
    public String getPermissions() { return permissions; }

    public static Builder builder() { return new Builder(); }

    public static Builder copy(Admin entity) {
        return new Builder()
                .id(entity.id)
                .adminId(entity.getAdminId())
                .role(entity.getRole())
                .permissions(entity.getPermissions());
    }

    public static final class Builder {
        private Long id;
        private String adminId;
        private String role;
        private String permissions;
        public Builder id(Long id) { this.id = id; return this; }
        public Builder adminId(String adminId) { this.adminId = adminId; return this; }
        public Builder role(String role) { this.role = role; return this; }
        public Builder permissions(String permissions) { this.permissions = permissions; return this; }
        public Admin build() {
            if (adminId == null) throw new IllegalArgumentException("adminId is required");
            if (role == null) throw new IllegalArgumentException("role is required");
            if (permissions == null) throw new IllegalArgumentException("permissions is required");

            return new Admin(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin other)) return false;
        return id != null && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() { return getClass().hashCode(); }

    @Override
    public String toString() { return "Admin" + "{id=" + id + "}"; }
}
