package com.RHLM.projectGym.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AdminDTO implements Serializable {

    private static final long serialVersionUID = 5561862846822530706L;

    private Long id;
    private Long idPersona;
    private String usuario;
    private String contra;
    private String correo;
}
