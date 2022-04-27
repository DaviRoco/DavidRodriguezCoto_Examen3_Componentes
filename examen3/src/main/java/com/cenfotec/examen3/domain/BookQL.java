package com.cenfotec.examen3.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@Entity
public class BookQL implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "status", nullable = false)
    private String status;
}
