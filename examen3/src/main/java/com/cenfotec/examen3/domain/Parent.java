package com.cenfotec.examen3.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_parent;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefonoPrimario;
    private String telefonoSecundario;
    @OneToMany
    private List<Children> children;

    public Parent() {
    }

    public Parent(Long id, String nombre, String cedula, String direccion, String telefonoPrimario, String telefonoSecundario) {
        this.id_parent = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefonoPrimario = telefonoPrimario;
        this.telefonoSecundario = telefonoSecundario;
    }

    public Parent(Long id, String nombre, String cedula, String direccion, String telefonoPrimario, String telefonoSecundario, List<Children> children) {
        this.id_parent = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefonoPrimario = telefonoPrimario;
        this.telefonoSecundario = telefonoSecundario;
        this.children = children;
    }

    public Long getId() {
        return id_parent;
    }

    public void setId(Long id) {
        this.id_parent = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoPrimario() {
        return telefonoPrimario;
    }

    public void setTelefonoPrimario(String telefonoPrimario) {
        this.telefonoPrimario = telefonoPrimario;
    }

    public String getTelefonoSecundario() {
        return telefonoSecundario;
    }

    public void setTelefonoSecundario(String telefonoSecundario) {
        this.telefonoSecundario = telefonoSecundario;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
}
