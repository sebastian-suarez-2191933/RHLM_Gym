package com.RHLM.projectGym.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "persona", schema = "public")
public class Persona implements Serializable {

    private static final long serialVersionUID = 5597646594519896333L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_nac")
    private Date fechanac;

    @Column(name = "identificacion")
    private int identificacion;

}
