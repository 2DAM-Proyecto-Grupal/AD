package org.example.proyecto_nomadas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resenya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String textoResenya;

    @Column
    //Valoracion numerica
    private Integer valoracion;

    //Fecha de creacion de la reseña
    @Column(name = "fecha_creacion_resenya")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaCreacion;

    //Identificacion del usuario que deja la reseña ?

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "lugar_id")
    private Lugar lugar;

    @Column(name = "usuario_id")
    private int id_usuario;
}
