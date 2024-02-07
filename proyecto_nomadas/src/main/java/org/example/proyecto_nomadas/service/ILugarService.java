package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Lugar;
import org.example.proyecto_nomadas.model.dto.LugarRequestDto;
import org.example.proyecto_nomadas.model.dto.LugarResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ILugarService {
    Lugar addLugar(LugarRequestDto lugar);
    Lugar modficarLugar(LugarRequestDto lugar);
    void deleteLugar(LugarRequestDto lugar);
    List<LugarResponseDto> findAll();
    List<LugarResponseDto> findLugarByNombre(String nombre);
}
