package com.RHLM.projectGym.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Long id;
    private Long idPersona;
    private Long idSuscripcion;
    private Double peso;
    private Double estatura;
    private String tipoCuerpo;
    private String porcentajeGraso;
    private String objetivo;

}
