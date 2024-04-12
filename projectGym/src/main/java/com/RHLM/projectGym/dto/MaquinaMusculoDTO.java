package com.RHLM.projectGym.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MaquinaMusculoDTO implements Serializable {

    private Long id;
    private Long idMaquina;
    private Long idMusculo;

    private String nombreMaquina;
    private String nombreMusculo;


}
