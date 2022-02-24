/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.dto;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author lion
 */
public class PageCriteria implements Serializable {

    private int first;
    private int size;
    private Map<String, Object> filteredBy;
    private Boolean isAscending;
    private String sortedBy;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<String, Object> getFilteredBy() {
        return filteredBy;
    }

    public void setFilteredBy(Map<String, Object> filteredBy) {
        this.filteredBy = filteredBy;
    }

    public Boolean getIsAscending() {
        return isAscending;
    }

    public void setIsAscending(Boolean isAscending) {
        this.isAscending = isAscending;
    }

    public String getSortedBy() {
        return sortedBy;
    }

    public void setSortedBy(String sortedBy) {
        this.sortedBy = sortedBy;
    }

    @Override
    public String toString() {
        return "PageCriteria{" + "first=" + first + ", size=" + size + ", filteredBy=" + filteredBy + ", isAscending=" + isAscending + ", sortedBy=" + sortedBy + '}';
    }

}
