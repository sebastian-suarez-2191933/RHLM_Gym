package com.RHLM.projectGym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "maquina_musculo", schema = "public")
public class MaquinaMusculo implements Serializable {

    private static final long serialVersionUID = 8464256357426679933L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_maquina")
    private Long idMaquina;

    @Column(name = "id_musculo")
    private Long idMusculo;

    //Relaciones

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_maquina",insertable = false,updatable = false)
    private Maquina maquina;

    //Relaciones

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_musculo",insertable = false,updatable = false)
    private Musculo musculo;


}
