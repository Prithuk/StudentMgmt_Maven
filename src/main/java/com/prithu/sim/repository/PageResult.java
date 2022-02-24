/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lion
 */
public class PageResult<T> implements Serializable {

    private final List<T> data;
    private final int size;
    private final int index;
    private final long count;

    public PageResult(List<T> data, long count, int index, int size) {
        this.data = data;
        this.size = size;
        this.index = index;
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    public int getIndex() {
        return index;
    }

    public long getCount() {
        return count;
    }
}
