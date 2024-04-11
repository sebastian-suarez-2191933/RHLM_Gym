package com.RHLM.projectGym.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles", schema = "public")
public class Roles implements Serializable {

    private static final long serialVersionUID = 4679409100396472021L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_desde")
    private Date fechaDesde;

    @Column(name = "fecha_hasta")
    private Date fechaHasta;
}
