package org.example.proyecto_nomadas.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Lugar;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResenyaResponseDto {


    private Integer id;

    private String textoResenya;


    private Integer valoracion;


    private LocalDate fechaCreacion;

    private Ciudad ciudad;


    private Lugar lugar;

    private int id_usuario;


}
