/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 */
//@Entity
//@Table(name = "student")
public class Student implements Serializable {

//    @Id
//    @Basic(optional = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sID;
    private String sName;
    private int sClass;
    private String sEmail;
    private Long sPhone;

    public Long getsID() {
        return sID;
    }

    public void setsID(Long sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public Long getsPhone() {
        return sPhone;
    }

    public void setsPhone(Long sPhone) {
        this.sPhone = sPhone;
    }

    public int getsClass() {
        return sClass;
    }

    public void setsClass(int sClass) {
        this.sClass = sClass;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.sID ^ (this.sID >>> 32));
        hash = 29 * hash + Objects.hashCode(this.sName);
        hash = 29 * hash + this.sClass;
        hash = 29 * hash + Objects.hashCode(this.sEmail);
        hash = 29 * hash + Objects.hashCode(this.sPhone);
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
        if (this.sID != other.sID) {
            return false;
        }
        if (this.sClass != other.sClass) {
            return false;
        }
        if (!Objects.equals(this.sName, other.sName)) {
            return false;
        }
        if (!Objects.equals(this.sEmail, other.sEmail)) {
            return false;
        }
        if (!Objects.equals(this.sPhone, other.sPhone)) {
            return false;
        }
        return true;
    }

    public Student(Long sID, String sName, String sAddress, String sEmail, Long sPhone, int sClass) {
        this.sID = sID;
        this.sName = sName;
        this.sClass = sClass;
        this.sEmail = sEmail;
        this.sPhone = sPhone;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" + "sID=" + sID + ", sName=" + sName + ", sClass=" + sClass + ", sEmail=" + sEmail + ", sPhone=" + sPhone + '}';
    }

}
