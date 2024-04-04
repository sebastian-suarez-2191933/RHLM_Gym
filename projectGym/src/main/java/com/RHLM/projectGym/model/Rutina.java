package com.RHLM.projectGym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "rutina", schema = "public")
public class Rutina implements Serializable {

    private static final long serialVersionUID = -1198449724165687516L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_maquina")
    private Long idMaquina;

    @Column(name = "descripcion")
    private String descripcion;

    //Relaciones

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_maquina",insertable = false,updatable = false)
    private Maquina maquina;

}
