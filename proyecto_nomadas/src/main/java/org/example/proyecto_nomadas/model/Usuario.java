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

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String email;

    //Apellidos para los usuarios ?
    //private String apellidos;
    @Column
    private String contrasena;

    //Telefono ?
    //private Long telefono;

    //Fecha creacion del usuario?
    //@Column(name = "fecha_creacion")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    //private LocalDate fechaCreacion;


}
