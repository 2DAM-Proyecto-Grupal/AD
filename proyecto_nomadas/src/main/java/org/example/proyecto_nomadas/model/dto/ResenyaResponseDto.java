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

    private String titulo;

    private String textoResenya;


    private Integer valoracion;


    private String fechaCreacion;

    private Ciudad ciudad;

    private Lugar lugar;

    private int uid_usuario;

    private String nombreUsuario;


}
