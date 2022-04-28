package com.cenfotec.examen3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefonoPrimario;
    private String telefonoSecundario;
    private String hijos;

    public Parent() {
    }

    public Parent(Long id, String nombre, String cedula, String direccion, String telefonoPrimario, String telefonoSecundario) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefonoPrimario = telefonoPrimario;
        this.telefonoSecundario = telefonoSecundario;
    }

    public Parent(Long id, String nombre, String cedula, String direccion, String telefonoPrimario, String telefonoSecundario, String hijos) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefonoPrimario = telefonoPrimario;
        this.telefonoSecundario = telefonoSecundario;
        this.hijos = hijos;
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

    public String getHijos() {
        return hijos;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefonoPrimario='" + telefonoPrimario + '\'' +
                ", telefonoSecundario='" + telefonoSecundario + '\'' +
                ", hijos='" + hijos + '\'' +
                '}';
    }
}
