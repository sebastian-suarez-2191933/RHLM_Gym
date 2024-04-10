package com.RHLM.projectGym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "rutina_maquina", schema = "public")
public class RutinaMaquina implements Serializable {

    private static final long serialVersionUID = 7644249687202579647L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_rutina")
    private Long idRutina;

    @Column(name = "id_maquina")
    private Long idMaquina;

    //Relaciones

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_rutina",insertable = false,updatable = false)
    private Rutina rutina;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_maquina",insertable = false,updatable = false)
    private Maquina maquina;
}
