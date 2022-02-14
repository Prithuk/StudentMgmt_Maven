/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.simw.controller;

import com.prithu.sim.dto.Marks;
import com.prithu.sim.dto.Student;
import com.prithu.sim.repository.MarksRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class MarksControllerWeb implements Serializable {

    private List<Marks> markList;
    private Marks marks;

    @Inject
    private MarksRepository marksRepository;

    public List<Marks> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Marks> markList) {
        this.markList = markList;
    }

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    @PostConstruct
    public void init() {
        markList = new ArrayList<>();
        marks = new Marks();
        loadMarks();

    }

    public void loadMarks() {
        markList = marksRepository.getAllMarksFromDB();
    }

    public void beforeCreate() {
        marks = new Marks();
        System.out.println(marks);

    }

    public void addMarks() {
        marksRepository.addNewMarks(marks);
        this.marks = new Marks();
        loadMarks();
    }

    public void beforeEdit(Long id) {
        marks = marksRepository.findById(id);
        System.out.println(marks);
    }

    public void editMarks() {
        marksRepository.editMarks(marks);
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Marks is updated successfully"));
        loadMarks();
    }

    public void deleteStudent(Marks marks) {
        marksRepository.deleteMarks(marks);
        loadMarks();
    }

    public void displayResult(Student student) {
        marksRepository.displayInfo(student);
    }

}
