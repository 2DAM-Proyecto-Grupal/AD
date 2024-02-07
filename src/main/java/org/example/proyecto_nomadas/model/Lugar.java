package org.example.proyecto_nomadas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    //Tipo de lugar donde se esté, restaurante, parque, hotel, ...
    @Column
    private String tipo;

    @Column
    private String direccion;

    //Descripcion del lugar ?
    //private String descripcion;

    //Horario de apertura ?
    //private String horario;

    //Valoracion del lugar ?
    //private Integer valoracion;

    @Column
    private String informacionContacto;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;
}
