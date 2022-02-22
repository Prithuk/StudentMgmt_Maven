/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.simw.controller;

import com.prithu.sim.dto.Subject;
import com.prithu.sim.repository.SubjectRepository;
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
public class SubjectControllerWeb implements Serializable {

    private List<Subject> subjectList;
    private Subject subject;

    @Inject
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SubjectRepository getSubjectRepository() {
        return subjectRepository;
    }

    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @PostConstruct
    public void init() {
        subjectList = new ArrayList<>();
        subject = new Subject();
        loadData();

    }

    public void loadData() {
        subjectList = subjectRepository.getSubjectListFromDB();
    }

    public void beforeCreate() {
        subject = new Subject();
        System.out.println(subject);
    }

    public void addSubject() {
        subjectRepository.addNew(subject);
        this.subject = new Subject();
        loadData();
    }

    public void beforeEdit(Long id) {
        subject = subjectRepository.findById(id);
        System.out.println(subject);
    }

    public void editSubject() {
        subjectRepository.edit(subject);
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Subject is updated successfully"));
        loadData();
    }

    public void deleteSubject(Subject subject) {
        subjectRepository.delete(subject);
        loadData();
    }

}
