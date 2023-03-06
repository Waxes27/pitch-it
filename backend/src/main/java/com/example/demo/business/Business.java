package com.example.demo.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Business {
    
    private @Id @GeneratedValue Long id;
    private String name;
    private String representativeFirstName;
    private String representativeLastName;
    private String role;
    private String email;
    private String password;


    public Business(String name, String representativeFirstName, String representativeLastName, String role, String email, String password) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.password = password;
        this.representativeFirstName = representativeFirstName;
        this.representativeLastName = representativeLastName;
    }


    public Business() {
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


    public String getRepresentativeName() {
        return this.representativeFirstName + " " + this.representativeLastName;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((representativeFirstName == null) ? 0 : representativeFirstName.hashCode());
        result = prime * result + ((representativeLastName == null) ? 0 : representativeLastName.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Business other = (Business) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (representativeFirstName == null) {
            if (other.representativeFirstName != null)
                return false;
        } else if (!representativeFirstName.equals(other.representativeFirstName))
            return false;
        if (representativeLastName == null) {
            if (other.representativeLastName != null)
                return false;
        } else if (!representativeLastName.equals(other.representativeLastName))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Business [id=" + id + ", name=" + name + ", representativeFirstName=" + representativeFirstName + ", representativeLastName=" + representativeLastName + ", role=" + role
                + ", email=" + email + ", password=" + password + "]";
    }
}
