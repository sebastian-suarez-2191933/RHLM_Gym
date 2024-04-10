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
@Table(name = "suscripcion", schema = "public")
public class Suscripcion implements Serializable {

    private static final long serialVersionUID = -6053744827546194368L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_tipo_suscripcion")
    private Long idTipoSuscripcion;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "estado")
    private Boolean estado;

    //Relaciones

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_tipo_suscripcion",insertable = false,updatable = false)
    private TipoSuscripcion tipoSuscripcion;
}
