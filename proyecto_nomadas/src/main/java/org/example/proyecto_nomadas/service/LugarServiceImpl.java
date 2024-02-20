package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Lugar;
import org.example.proyecto_nomadas.model.dto.CiudadResponseDto;
import org.example.proyecto_nomadas.model.dto.LugarRequestDto;
import org.example.proyecto_nomadas.model.dto.LugarResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import org.example.proyecto_nomadas.repository.ILugarRepository;
import org.springframework.stereotype.Service;

@Service
public class LugarServiceImpl implements ILugarService{
    @Autowired
    private ILugarRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Lugar addLugar(LugarRequestDto lugar) {
        Lugar lugar1 = modelMapper.map(lugar, Lugar.class);

        return repo.save(lugar1);
    }

    @Override
    public Lugar modficarLugar(LugarRequestDto lugar) {
        Lugar lugar1 = modelMapper.map(lugar, Lugar.class);

        return repo.save(lugar1);
    }

    @Override
    public void deleteLugar(LugarRequestDto lugar) {
        Lugar lugar1 = modelMapper.map(lugar, Lugar.class);

        repo.delete(lugar1);
    }

    @Override
    public List<LugarResponseDto> findAll() {
        List <Lugar> list = repo.findAll();

        return list.stream().map(l -> modelMapper.map(l, LugarResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LugarResponseDto> findLugarByNombre(String nombre) {
        List <Lugar> list = repo.findLugarByNombre(nombre);

        return list.stream().map(l -> modelMapper.map(l, LugarResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LugarResponseDto> findByCiudad(Ciudad ciudad) {
        List<Lugar> list = repo.findByCiudad(ciudad);

        return list.stream().map(l->modelMapper.map(l, LugarResponseDto.class)).collect(Collectors.toList());
    }
}
