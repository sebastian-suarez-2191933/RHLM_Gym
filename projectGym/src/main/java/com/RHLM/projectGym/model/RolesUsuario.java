package com.RHLM.projectGym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles_usuario", schema = "public")
public class RolesUsuario implements Serializable {

    private static final long serialVersionUID = -1272578386248774443L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "fecha_desde")
    private Date fechaDesde;

    @Column(name = "fecha_hasta")
    private Date fechaHasta;

    //Relaciones

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_persona",insertable = false,updatable = false)
    private Persona persona;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_rol",insertable = false,updatable = false)
    private Roles roles;
}
