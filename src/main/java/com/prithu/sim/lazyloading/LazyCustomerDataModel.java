/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.lazyloading;

import com.prithu.sim.dto.Student;
import com.prithu.sim.repository.StudentRepository;
import java.util.List;
import java.util.Map;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

/**
 *
 * @author lion
 */
public class LazyCustomerDataModel extends LazyDataModel<Student> {

    private List<Student> datasource;

    private StudentRepository repo;

    public LazyCustomerDataModel(StudentRepository repository) {
        repo = repository;
    }

    @Override
    public Student getRowData(String rowKey) {
        for (Student student : datasource) {
            if (student.getId() == Integer.parseInt(rowKey)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public String getRowKey(Student student) {
        return String.valueOf(student.getId());
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        int count = repo.count();
        System.out.println("count:" + count);
        return count;
    }

    @Override
    public List<Student> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        List<Student> students = repo.lazyload(offset, pageSize);
        System.out.println(" std count:" + students.size());
        return students;
    }
}
