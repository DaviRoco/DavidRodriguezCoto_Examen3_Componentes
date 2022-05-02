package com.cenfotec.examen3.domain;

public class BookCount {
    private String childName;

    private int count;

    public BookCount() {
    }

    public BookCount(String childName, int count) {
        this.childName = childName;
        this.count = count;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
