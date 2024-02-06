package org.example.proyecto_nomadas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CiudadResponseDto {

    private String nombre;

    private String pais;

    private String codigoPostal;

    private String region;


}
