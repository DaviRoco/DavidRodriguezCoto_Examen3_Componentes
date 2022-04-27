package com.cenfotec.examen3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookChildRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long idBook;
    private String nameBook;
    private Long idChild;
    private String nameChild;

    public BookChildRecord() {
    }

    public BookChildRecord(int id, Long idBook, String nameBook, Long idChild, String nameChild) {
        this.id = id;
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.idChild = idChild;
        this.nameChild = nameChild;
    }

    public BookChildRecord(int id, Long idBook, Long idChild) {
        this.id = id;
        this.idBook = idBook;
        this.idChild = idChild;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Long getIdChild() {
        return idChild;
    }

    public void setIdChild(Long idChild) {
        this.idChild = idChild;
    }

    public String getNameChild() {
        return nameChild;
    }

    public void setNameChild(String nameChild) {
        this.nameChild = nameChild;
    }
}
