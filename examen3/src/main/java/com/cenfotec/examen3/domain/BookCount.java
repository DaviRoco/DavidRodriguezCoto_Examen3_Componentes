package com.cenfotec.examen3.domain;

public class BookCount {
    private String nombreLibro;

    private int count;

    public BookCount() {
    }

    public BookCount(String nombreLibro, int count) {
        this.nombreLibro = nombreLibro;
        this.count = count;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
