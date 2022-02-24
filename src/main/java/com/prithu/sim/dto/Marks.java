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

@Entity
@Table(name = "marks")
public class Marks extends AbstractUserTracker implements Serializable {

    private Double subMarks;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Marks() {
    }

    public Marks(Double subMarks, Subject subject, Student student) {
        this.subMarks = subMarks;
        this.subject = subject;
        this.student = student;
    }

    public Double getSubMarks() {
        return subMarks;
    }

    public void setSubMarks(Double subMarks) {
        this.subMarks = subMarks;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.subMarks);
        hash = 73 * hash + Objects.hashCode(this.subject);
        hash = 73 * hash + Objects.hashCode(this.student);
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

        if (!Objects.equals(this.subMarks, other.subMarks)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Marks{" + "id=" + super.getId() + ", subMarks=" + subMarks + ", subject=" + subject + ", student=" + student + '}';
    }

}
