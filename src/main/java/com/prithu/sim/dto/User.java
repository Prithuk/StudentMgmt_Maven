/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_info")
public class User extends AbstractEntity implements Serializable {

    
    @NotNull(message = "Name is required")
    @Size(min = 4, message = "Name should at least be 4 characters long")
    private String name;

    @NotNull
    @Size(min = 6, message = "password should be at least 6 characters long")
    private String password;

    public void User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + super.getId() + ", name=" + name + ", password=" + password + '}';
    }

}
