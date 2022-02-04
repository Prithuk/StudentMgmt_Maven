/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.dao;

import com.prithu.sim.dto.Subject;
import java.util.List;

/**
 *
 * @author lion
 */
public interface SubjectDao {
    
    public void addSubject(Subject subject); 
    public List<Subject> viewSubject(); 
    
}
