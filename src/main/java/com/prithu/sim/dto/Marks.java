/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.dto;

import java.util.Objects;

/**
 *
 * @author lion
 */
public class Marks {

    private Long id ; 
    private Long studentId;
    private Long subjectId;
    private float subMarks;
    

    public Marks() {
    }

    public Marks(Long studentId, Long subjectId, float subMarks) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.subMarks = subMarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public float getSubMarks() {
        return subMarks;
    }

    public void setSubMarks(float subMarks) {
        this.subMarks = subMarks;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.studentId);
        hash = 67 * hash + Objects.hashCode(this.subjectId);
        hash = 67 * hash + Float.floatToIntBits(this.subMarks);
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
        final Marks other = (Marks) obj;
        if (Float.floatToIntBits(this.subMarks) != Float.floatToIntBits(other.subMarks)) {
            return false;
        }
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (!Objects.equals(this.subjectId, other.subjectId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Marks{" + "studentId=" + studentId + ", subjectId=" + subjectId + ", subMarks=" + subMarks + '}';
    }

}
