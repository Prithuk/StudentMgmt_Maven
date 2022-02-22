/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.converter;

import com.prithu.sim.dto.Student;
import com.prithu.sim.repository.StudentRepository;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author lion
 */
@FacesConverter(value = "studentConverter", forClass = Student.class)
@RequestScoped
public class StudentConverter implements Converter {

    @Inject
    private StudentRepository studentRepository;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.isEmpty()) {
            return null;
        }
        try {

            Object obj = studentRepository.findById(Long.valueOf(value));

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Customer", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (!(value instanceof Student)) {
            return null;
        }
        String s = String.valueOf(((Student) value).getId());

        return s;
    }
}
