package com.cenfotec.examen3.domain;

import javax.persistence.*;

@Entity
public class Children {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_child;
    private String nombre;
    private String planUsuario;
    private String alergias;
    private int idParent;

    public Children() {
    }

    public Children(Long id, String nombre, String planUsuario, String alergias, Long idParent) {
        this.id_child = id;
        this.nombre = nombre;
        this.planUsuario = planUsuario;
        this.alergias = alergias;
    }

    public Children(Long id_child, String nombre, String planUsuario, String alergias, int idParent) {
        this.id_child = id_child;
        this.nombre = nombre;
        this.planUsuario = planUsuario;
        this.alergias = alergias;
        this.idParent = idParent;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlanUsuario() {
        return planUsuario;
    }

    public void setPlanUsuario(String planUsuario) {
        this.planUsuario = planUsuario;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Long getId_child() {
        return id_child;
    }

    public void setId_child(Long id_child) {
        this.id_child = id_child;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }
}
