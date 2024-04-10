package com.RHLM.projectGym.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "musculo", schema = "public")
public class Musculo implements Serializable {
    private static final long serialVersionUID = 4606780899612731531L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
}
