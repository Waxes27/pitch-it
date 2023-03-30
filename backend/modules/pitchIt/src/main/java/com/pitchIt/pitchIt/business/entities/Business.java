package com.pitchIt.pitchIt.business.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BUSINESS")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="BUSINESS_NAME", length=50, nullable=false, unique=true)
    private String name;
    @Column(name="REP_FIRST_NAME", length=20, nullable=false, unique=false )
    private String representativeFirstName;
    @Column(name="REP_LAST_NAME", length=20, nullable=false, unique=false )
    private String representativeLastName;
    @Column(name="REP_ROLE", length=20, nullable=false, unique=false )
    private String representativeRole;
    @Column(name="REP_EMAIL", length=30, nullable=false, unique=true )
    private String email;
    @Column(name="REP_PASSWORD", length=50, nullable=false, unique=false )
    private String password;

    public Business() {
    }


    public Business(String name, String representativeFirstName, String representativeLastName, String representativeRole, String email, String password) {
        this.name = name;
        this.representativeFirstName = representativeFirstName;
        this.representativeLastName = representativeLastName;
        this.representativeRole = representativeRole;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepresentativeFirstName() {
        return representativeFirstName;
    }

    public void setRepresentativeFirstName(String representativeFirstName) {
        this.representativeFirstName = representativeFirstName;
    }

    public String getRepresentativeLastName() {
        return representativeLastName;
    }

    public void setRepresentativeLastName(String representativeLastName) {
        this.representativeLastName = representativeLastName;
    }

    public String getRepresentativeRole() {
        return representativeRole;
    }

    public void setRepresentativeRole(String representativeRole) {
        this.representativeRole = representativeRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Business business = (Business) o;
        return Objects.equals(getId(), business.getId()) && Objects.equals(getName(), business.getName()) && Objects.equals(getRepresentativeFirstName(), business.getRepresentativeFirstName()) && Objects.equals(getRepresentativeLastName(), business.getRepresentativeLastName()) && Objects.equals(getRepresentativeRole(), business.getRepresentativeRole()) && Objects.equals(getEmail(), business.getEmail()) && Objects.equals(getPassword(), business.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRepresentativeFirstName(), getRepresentativeLastName(), getRepresentativeRole(), getEmail(), getPassword());
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", representativeFirstName='" + representativeFirstName + '\'' +
                ", representativeLastName='" + representativeLastName + '\'' +
                ", representativeRole='" + representativeRole + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
