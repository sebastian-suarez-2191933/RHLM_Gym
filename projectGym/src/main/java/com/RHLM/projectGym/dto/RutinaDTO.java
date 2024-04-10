package com.RHLM.projectGym.dto;

import com.RHLM.projectGym.model.Maquina;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RutinaDTO implements Serializable {

    private Long id;
    private String nombre;
    private Long idMaquina;
    private String descripcion;

    private String nombreMaquina;
}
