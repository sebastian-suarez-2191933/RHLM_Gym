package com.RHLM.projectGym.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tipo_suscripcion", schema = "public")
public class TipoSuscripcion implements Serializable {

    private static final long serialVersionUID = -8050859745142300672L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private Long nombre;

    @Column(name = "tiempo")
    private Date tiempo;

    @Column(name = "precio")
    private int precio;
}
