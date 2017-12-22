package com.liguo.nihao.domain;

import java.util.List;

public class Page {
    private int index;
    private int size;
    private List list;

    public Page(int index, int size, List list) {
        this.index = index;
        this.size = size;
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
