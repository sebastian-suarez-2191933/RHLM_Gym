package com.RHLM.projectGym.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AsistenciaDTO {
    private Long id;
    private Long idUsuario;
    private Long idRutina;

    @Temporal(TemporalType.DATE)
    private Date llegada;

    @Temporal(TemporalType.DATE)
    private Date salida;

    //De la tabla Usuario
    private String nombreUsuario;

    //De la tabla Rutina
    private String nombreRutina;

    //De la tabla Suscripcion
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    //De la tabla tipo_suscripcion
    private String nombreSuscripcion;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    private Boolean estado;
}
