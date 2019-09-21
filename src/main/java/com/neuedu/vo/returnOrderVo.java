package com.neuedu.vo;

import java.util.List;

public class returnOrderVo {
    private int currentPage;
    private int totalPage;
    private List<oderVo> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<oderVo> getList() {
        return list;
    }

    public void setList(List<oderVo> list) {
        this.list = list;
    }
}
