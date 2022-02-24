///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.sim.lazyloading;
//
//import com.prithu.sim.dto.IModel;
//import com.prithu.sim.dto.PageCriteria;
//import com.prithu.sim.repository.IDataPageable;
//import com.prithu.sim.repository.PageResult;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import org.primefaces.model.FilterMeta;
//import org.primefaces.model.LazyDataModel;
//import org.primefaces.model.SortMeta;
//import org.primefaces.model.SortOrder;
//
//public class CustomLazyDataModel<T extends IModel> extends LazyDataModel<T> {
//
//    private PageResult<T> page;
//    private IDataPageable dataPageable;
//
//    /**
//     *
//     * @author lion
//     */
//    public CustomLazyDataModel(IDataPageable dataPageable) {
//        this.dataPageable = dataPageable;
//    }
//
//    @Override
//    public int count(Map<String, FilterMeta> map) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<T> load(int first, int size, String sortColumn, SortOrder sortOrder, Map<String, Object> filterBy) {
//        try {
//            PageCriteria pageCriteria = new PageCriteria();
//            pageCriteria.setFilteredBy(filterBy);
//            pageCriteria.setFirst(first);
//            pageCriteria.setSize(size);
//            pageCriteria.setSortedBy(sortColumn);
//            pageCriteria.setIsAscending(sortOrder == null ? null
//                    : (sortOrder == SortOrder.ASCENDING
//                            ? true : (sortOrder == SortOrder.DESCENDING ? false : null)));
//            page = this.dataPageable.getData(pageCriteria);
//        } catch (Exception ex) {
//         //   JSFUtil.addErrorMessage(ex.getMessage());
//            page = new PageResult<>(new ArrayList<>(), 0, first, size);
//        }
//        this.setRowCount((int) page.getCount());
//        return page.getData();
//    }
//
//    @Override
//    public void setRowIndex(int rowIndex) {
//        if (rowIndex == -1 || getPageSize() == 0) {
//            super.setRowIndex(-1);
//        } else {
//            super.setRowIndex(rowIndex % getPageSize());
//        }
//    }
//
//    public T getRowData(String rowKey) {
//        List<T> data = (List<T>) getWrappedData();
//        for (T d : data) {
//            if (d.getId() != null) {
//                if (d.getId().toString().equals(rowKey)) {
//                    return d;
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     *
//     * @param object
//     * @return
//     */
//    @Override
//    public Object getRowKey(T object) {
//        return object != null ? object.getId() : null;
//    }
//
//    @Override
//    public List<T> load(int i, int i1, Map<String, SortMeta> map, Map<String, FilterMeta> map1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
