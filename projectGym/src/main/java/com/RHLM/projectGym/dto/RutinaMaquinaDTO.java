package com.RHLM.projectGym.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RutinaMaquinaDTO implements Serializable {

    private Long id;
    private Long idRutina;
    private Long idMaquina;

    private String nombreRutina;
    private String nombreMaquina;
}
