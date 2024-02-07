package org.example.proyecto_nomadas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    //Poblacion ?
    //private Long poblacion;
    @Column
    private String pais;

    @Column
    private String codigoPostal;

    @Column
    private String region;


}


