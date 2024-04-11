package com.RHLM.projectGym.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class RolesUsuarioDTO implements Serializable {

    private static final long serialVersionUID = -7402002175789709142L;

    private Long id;
    private Long idRol;
    private Long idPersona;
    private Date fechaDesde;
    private Date fechaHasta;

}
