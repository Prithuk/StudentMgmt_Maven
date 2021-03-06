/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 */
@Entity
@Table(name = "student")
public class Student extends AbstractUserTracker implements Serializable {

    @NotNull(message = "Name is required")
    @Size(min = 4, message = "At least enter four characters")
    private String sname;

    @NotNull(message = "Grade is required")
    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;

    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Phone is required")
    private Long phone;

    public Student() {

    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.sname);
        hash = 59 * hash + Objects.hashCode(this.grade);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.phone);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.sname, other.sname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }

        if (!Objects.equals(this.grade, other.grade)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "sid=" + super.getId() + ", sname=" + sname + ", grade=" + grade + ", email=" + email + ", phone=" + phone + '}';
    }
}
