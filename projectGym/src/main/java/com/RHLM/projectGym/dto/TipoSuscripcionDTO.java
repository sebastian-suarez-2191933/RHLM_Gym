package com.RHLM.projectGym.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class TipoSuscripcionDTO implements Serializable {

    private static final long serialVersionUID = -2727210240065176735L;

    private Long id;
    private String nombre;
    private Date tiempo;
    private Integer precio;
}
