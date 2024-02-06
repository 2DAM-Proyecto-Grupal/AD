package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Resenya;
import org.example.proyecto_nomadas.model.Usuario;
import org.example.proyecto_nomadas.model.dto.CiudadRequestDto;
import org.example.proyecto_nomadas.model.dto.ResenyaRequestDto;
import org.example.proyecto_nomadas.model.dto.ResenyaResponseDto;
import org.example.proyecto_nomadas.model.dto.UsuarioRequestDto;

import java.util.List;

public interface IResenyaService {
    Resenya addResenya (ResenyaRequestDto resenya);
    Resenya modificarResenya (ResenyaRequestDto resenya);
    void deleteResenya (ResenyaRequestDto resenya);
    List<ResenyaResponseDto> findAll();
    List<ResenyaResponseDto> findByCiudad(CiudadRequestDto ciudad);
    List<ResenyaResponseDto> findByUsuario(UsuarioRequestDto usuario);
}
