package com.RHLM.projectGym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usuario", schema = "public")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 4043375346372107144L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "id_suscripcion")
    private Long idSuscripcion;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "estatura")
    private Double estatura;

    @Column(name = "tipo_cuerpo")
    private String tipoCuerpo;

    @Column(name = "porcentaje_graso")
    private String porcentajeGraso;

    @Column(name = "obejtivo")
    private String objetivo;

    //Relaciones

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_persona",insertable = false,updatable = false)
    private Persona persona;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_suscripcion",insertable = false,updatable = false)
    private Suscripcion suscripcion;
}
