package com.cenfotec.examen3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;


public class Family {
    private Parent parent;
    private ArrayList<Children> children;

    public Family() {
    }

    public Family(Parent parent, ArrayList<Children> children) {
        this.parent = parent;
        this.children = children;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }
}
