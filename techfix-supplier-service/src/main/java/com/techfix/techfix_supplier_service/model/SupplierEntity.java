package com.techfix.techfix_supplier_service.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suppliers")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactEmail;
    private String contactPhone;

    public SupplierEntity() {}

    public SupplierEntity(Long id, String name, String contactEmail, String contactPhone) {
        this.id = id;
        this.name = name;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    // Getters and setters...

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SupplierEntity that = (SupplierEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(contactEmail, that.contactEmail) &&
                Objects.equals(contactPhone, that.contactPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contactEmail, contactPhone);
    }

    // Getters / Setters omitted for brevity
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
}
