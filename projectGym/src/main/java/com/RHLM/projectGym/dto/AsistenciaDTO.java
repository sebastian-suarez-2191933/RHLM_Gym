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


    private String nombreUsuario;
    private String nombreRutina;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)

    private Date fechaFin;
    private Boolean estado;
}
