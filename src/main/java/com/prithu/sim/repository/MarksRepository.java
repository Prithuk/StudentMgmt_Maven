/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.Marks;
import com.prithu.sim.dto.Student;
import com.prithu.sim.vo.ResultVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lion
 */
@Stateless
public class MarksRepository extends AbstractUserTrackerRepository<Marks> {

    @PersistenceContext(unitName = "simDS")
    private EntityManager entityManager;

    public MarksRepository() {
        super(Marks.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Inject
    private SubjectRepository subjectRepository;
    List<MarksRepository> marksRepositorys = new ArrayList<>();

    /**
     *
     * @return
     */
//    public MarksRepository() {
//        subjectRepository = new SubjectRepository();
//        super(Marks.class); 
//
//    }
    public SubjectRepository getSubjectRepository() {
        return subjectRepository;
    }

    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Marks> getAllMarksFromDB() {

        List<Marks> marksList = new ArrayList<>();

        try {
            Query query = entityManager.createQuery("select m from Marks m", Marks.class);
            marksList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return marksList;
    }

    public List<Marks> getByStudent(Student student) {
        List<Marks> marksList = new ArrayList<>();
        try {
            Query query = entityManager.createQuery("select m from Marks m where m.student.id=:student", Marks.class);
            query.setParameter("student", student.getId());
            marksList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return marksList;
    }

    public ResultVo displayInfo(Student student) {
        ResultVo resultVo = new ResultVo();
        resultVo.setStudent(student);
        System.out.println("Result of" + student.getSname() + "is");
        System.out.println("Subject" + "\t" + "Marks");
        List<Marks> markList = getByStudent(student);
        resultVo.setMarksList(markList);

        for (Marks marks : markList) {
            System.out.println(marks.getSubject() + "\t" + marks.getSubMarks());
        }
        System.out.println("total marks :" + getTotalMarks(markList));

        float totalSubject = markList.size();
        double percent = getPercentage(markList, totalSubject);
        System.out.println("Percentage is :" + percent);
        System.out.println("Divison is :" + getDivison(percent));
        resultVo.setPercentage(percent);
        resultVo.setDivison(getDivison(percent));
        resultVo.setGpa(studentGpa(percent));
        resultVo.setGradeConversion(convertPercentToGrade(percent));
        return resultVo;
    }

    public String getDivison(double percent) {

        if (percent >= 80 && percent < 100) {
            return "--- Distinction ---";
        } else if (percent >= 60 && percent < 80) {
            return "--- First Divison ---";
        } else if (percent >= 45 && percent < 60) {
            return "Second Divison";
        } else if (percent >= 40 && percent < 45) {
            return "Third Divison";
        } else {
            return "Failed";
        }
    }

    public double getTotalMarks(List<Marks> markList) {
        double total = 0;
        for (Marks marks : markList) {
            total = total + marks.getSubMarks();
        }
        return total;
    }

    public List<Long> getUnqSubjectsForStd(Student student, List<Marks> marksList) {
        List<Long> subjectList = new ArrayList<>();
        for (Marks m : marksList) {
            if (m.getStudent().equals(student.getId()) && !subjectList.contains(m.getSubject().getId())) {
                subjectList.add(m.getSubject().getId());
            }
        }
        return subjectList;
    }

    public List<Long> getUnqStudents(List<Marks> marksList) {
        List<Long> stds = new ArrayList<>();
        for (Marks m : marksList) {
            if (!stds.contains(m.getStudent().getId())) {
                stds.add(m.getStudent().getId());
            }
        }
        return stds;
    }

    public Map<Long, List<Long>> getStudentSubjectsMap(List<Marks> marks) {
        Map<Long, List<Long>> studentSubMap = new HashMap<>();
        List<Long> students = getUnqStudents(marks);
        for (Long std : students) {
            Student student = new Student();
            student.setId(std);
            studentSubMap.put(std, getUnqSubjectsForStd(student, marks));
        }
        return studentSubMap;
    }

    public double getPercentage(List<Marks> markList, float totalSubject) {
        double totalMarks = getTotalMarks(markList);
        double percentage = (totalMarks / (totalSubject * 100.0)) * 100.0;
        return percentage;
    }

    public String convertPercentToGrade(double percent) {
        if (percent >= 90 && percent < 100) {
            return "A+";
        } else if (percent >= 80 && percent < 90) {
            return "A";
        } else if (percent >= 75 && percent < 80) {
            return "A-";
        } else if (percent >= 70 && percent < 75) {
            return "B+";
        } else if (percent >= 60 && percent < 70) {
            return "B";
        } else if (percent >= 50 && percent < 60) {
            return "B-";
        } else if (percent >= 40 && percent < 50) {
            return "C";
        } else {
            return "Failed";
        }
    }

    public double studentGpa(double percent) {

        /* 
       need to have :  hours  ,grade, points(from grade), QP(hours*points)
        TOTAL hours , total qp
        
        gpa = total qp / total hours 
        
        gpa = (percentage/100)*4
        
         */
//        final Integer subjectCreditHours = 3;
        double gpa = ((percent / 100) * 4);
        System.out.println("gpa is :" + gpa);
        return gpa;
    }

}
