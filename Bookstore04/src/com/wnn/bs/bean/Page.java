package com.wnn.bs.bean;

import java.util.List;

public class Page<T> {

    private List<T> list;
    private int pageSize;
    private int pageNo;
    private int totalRecord;
    private int totalPage;
    private int index;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(final List<T> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        if(pageNo<=1){
            return 1;
        }
        if(pageNo>=getTotalPage()){
            return getTotalPage();
        }
        return pageNo;
    }

    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(final int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return getTotalRecord()%pageSize==0?getTotalRecord()/pageSize:getTotalRecord()/pageSize+1;
    }

//    public void setTotalpage(final int totalpage) {
//        this.totalpage = totalpage;
//    }

    public int getIndex() {
        return (getPageNo()-1)*pageSize;
    }

//    public void setIndex(final int index) {
//        this.index = index;
//    }
}
