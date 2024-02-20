package org.example.proyecto_nomadas.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CiudadResponseDto {

    private int id;

    @Column(name = "jornada_laboral")
    private String jornadaLaboral;

    @Column(name = "cashless_society")
    private Integer cashlessSociety;

    @Column(name = "cost_of_living")
    private Integer costLiving;

    @Column(name = "cost_of_living_for_expat")
    private Integer costExpat;

    @Column(name = "cost_of_living_for_local")
    private Integer costLocal;

    @Column(name = "freedom_of_speech")
    private Integer freeSpeech;

    @Column(name = "healthcare")
    private Integer healthcare;

    @Column(name = "internet")
    private Integer internet;

    @Column(name = "peace")
    private Integer peace;

    @Column(name = "quality_of_life")
    private Integer qualityLife;

    @Column(name = "safety")
    private Integer safety;

    @Column(name = "region")
    private String region;

    @Column(name = "country")
    private String country;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Lob
    @Column(name = "imagedata")
    private byte[] imagen;


}
