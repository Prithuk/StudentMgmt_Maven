/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.PageCriteria;

/**
 *
 * @author lion
 */
@FunctionalInterface
public interface IDataPageable {

    PageResult getData(PageCriteria pageCriteria);

}
