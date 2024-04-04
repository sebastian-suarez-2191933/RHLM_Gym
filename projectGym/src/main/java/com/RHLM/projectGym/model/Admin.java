package com.RHLM.projectGym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.patterns.PerObject;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "admin", schema = "public")
public class Admin implements Serializable {

    private static final long serialVersionUID = -1040333872496311744L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona")
    private Long idPersona;

    //Relaciones
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_persona",insertable = false,updatable = false)
    private Persona persona;
}
