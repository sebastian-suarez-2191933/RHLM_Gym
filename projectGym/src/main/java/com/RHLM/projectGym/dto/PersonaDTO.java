package com.RHLM.projectGym.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PersonaDTO implements Serializable {

    private static final long serialVersionUID = 8238147206715405967L;

    private Long id;
    private String nombre;
    private Date fechanac;
    private Integer identificacion;
}
