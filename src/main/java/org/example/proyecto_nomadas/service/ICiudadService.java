package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.dto.CiudadRequestDto;
import org.example.proyecto_nomadas.model.dto.CiudadResponseDto;

import java.util.List;

public interface ICiudadService {
    Ciudad addCiudad(CiudadRequestDto ciudad);
    Ciudad modficarCiudad(CiudadRequestDto ciudad);
    void deleteCiudad(CiudadRequestDto ciudad);
    List<CiudadResponseDto> findAll();
    List<CiudadResponseDto> findCiudadByNombre(String nombre);
}
