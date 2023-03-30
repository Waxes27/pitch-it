package com.pitchIt.pitchIt.investor.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "INVESTOR")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="FIRSTNAME", length = 20, nullable = false, unique = false)
    private String firstName;

    @Column(name="LASTNAME", length = 20, nullable = false, unique = false)
    private String lastName;

    @Column(name="EMAIL", length = 30, nullable = false, unique = true)
    private String email;

    @Column(name="PASSWORD", length = 20, nullable = false, unique = false)
    private String password;

    public Investor() {
    }

    public Investor(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

        Investor investor = (Investor) o;

        if (!Objects.equals(id, investor.id)) return false;
        if (getFirstName() != null ? !getFirstName().equals(investor.getFirstName()) : investor.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(investor.getLastName()) : investor.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(investor.getEmail()) : investor.getEmail() != null) return false;
        return getPassword() != null ? getPassword().equals(investor.getPassword()) : investor.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
