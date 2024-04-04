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
@Table(name = "asistencia", schema = "public")
public class Asistencia implements Serializable {

    private static final long serialVersionUID = -6779823095641794813L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_rutina")
    private Long idRutina;

    @Column(name = "llegada")
    private Date llegada;

    @Column(name = "salida")
    private Date salida;

    //Relaciones

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario",insertable = false,updatable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_rutina",insertable = false,updatable = false)
    private Rutina rutina;

}
