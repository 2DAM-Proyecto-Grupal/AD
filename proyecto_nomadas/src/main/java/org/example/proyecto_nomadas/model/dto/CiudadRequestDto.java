package org.example.proyecto_nomadas.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiudadRequestDto {

    private String jornadaLaboral;

    private Integer cashlessSociety;

    private Integer costLiving;

    private Integer costExpat;

    private Integer costLocal;

    private Integer freeSpeech;

    private Integer healthcare;

    private Integer internet;

    private Integer peace;

    private Integer qualityLife;

    private Integer safety;

    private String region;

    private String country;

    private String nombre;

    private Double latitude;

    private Double longitude;




}
