package com.cenfotec.examen3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Children {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String planUsuario;
    private String alergias;
    private Long idParent;

    public Children() {
    }

    public Children(Long id, String nombre, String planUsuario, String alergias, Long idParent) {
        this.id = id;
        this.nombre = nombre;
        this.planUsuario = planUsuario;
        this.alergias = alergias;
        this.idParent = idParent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdParent() {
        return idParent;
    }

    public void setIdParent(Long idParent) {
        this.idParent = idParent;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nombre='" + nombre +
                ", planUsuario=" + planUsuario +
                ", alergias=" + alergias  +
                ", idParent=" + idParent +
                '}';
    }
}
