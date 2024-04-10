package com.RHLM.projectGym.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class MaquinaDTO implements Serializable {

    private Long id;
    private String nombre;
}
