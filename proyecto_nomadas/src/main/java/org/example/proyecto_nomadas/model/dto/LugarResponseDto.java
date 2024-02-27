package org.example.proyecto_nomadas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proyecto_nomadas.model.Ciudad;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LugarResponseDto {

    private int id;

    private String nombre;


    private String tipo;

    private String direccion;


    private String informacionContacto;


    private Ciudad ciudad;



}
