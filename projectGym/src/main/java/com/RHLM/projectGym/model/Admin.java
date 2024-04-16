package com.RHLM.projectGym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "admin", schema = "public")
public class Admin implements Serializable {

    private static final long serialVersionUID = -8391740459358940205L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idpersona")
    private Long idPersona;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contra")
    private String contra;

    @Column(name = "correo")
    private String correo;

    //Relaciones

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idpersona",insertable = false,updatable = false)
    private Persona persona;
}
