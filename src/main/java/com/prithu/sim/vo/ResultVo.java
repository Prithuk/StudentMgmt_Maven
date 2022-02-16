
package com.prithu.sim.vo;

import com.prithu.sim.dto.Marks;
import com.prithu.sim.dto.Student;
import java.io.Serializable;
import java.util.List;

public class ResultVo implements Serializable {

    private Student student;
    private String divison;
    private Double percentage;
    private List<Marks> marksList;
    private Double gpa;
    private String gradeConversion ; 

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getDivison() {
        return divison;
    }

    public void setDivison(String divison) {
        this.divison = divison;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public List<Marks> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Marks> marksList) {
        this.marksList = marksList;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getGradeConversion() {
        return gradeConversion;
    }

    public void setGradeConversion(String gradeConversion) {
        this.gradeConversion = gradeConversion;
    }
    

}
