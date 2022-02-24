/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.lazyloading;

import com.prithu.sim.dto.Student;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

/**
 *
 * @author lion
 */
public class LazySorter implements Comparator<Student> {

    private String sortField;
    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Student student1, Student student2) {
        try {
//            Object value1 = ShowcaseUtil .getPropertyValueViaReflection(student1, sortField);
//            Object value2 = ShowcaseUtil.getPropertyValueViaReflection(student2, sortField);
//
            int value = ((Comparable) student1).compareTo(student2);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
