/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.simw.controller;

import com.prithu.sim.dto.Grade;
import com.prithu.sim.repository.GradeRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lion
 */
@ViewScoped
@Named
public class GradeController implements Serializable {

    private List<Grade> gradeList;
    private Grade grade;

    @Inject
    private GradeRepository gradeRepository;

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @PostConstruct
    public void init() {
        gradeList = new ArrayList<>();
        grade = new Grade();
        loadData();

    }

    public void loadData() {
        gradeList = gradeRepository.getAllGradeFromDB();
    }

    public void beforeCreate() {
        grade = new Grade();
        System.out.println(grade);
    }

    public void addGrade() {
        gradeRepository.addNew(grade);
        this.grade = new Grade();
        loadData();
    }

    public void beforeEdit(Long id) {
        grade = gradeRepository.findById(id);
        System.out.println(grade);
    }

    public void editGrade() {
        gradeRepository.edit(grade);
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Grade is updated successfully"));
        loadData();
    }

    public void deleteGrade(Grade grade) {
        gradeRepository.delete(grade);
        loadData();
    }

}
