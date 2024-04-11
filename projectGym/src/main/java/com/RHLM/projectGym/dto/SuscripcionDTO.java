package com.RHLM.projectGym.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class SuscripcionDTO implements Serializable {

    private static final long serialVersionUID = -8774065660632497822L;

    private Long id;
    private Long idTipoSuscripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean estado;
}
