package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.dto.CiudadRequestDto;
import org.example.proyecto_nomadas.model.dto.CiudadResponseDto;
import org.example.proyecto_nomadas.repository.ICiudadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CiudadServiceImpl implements ICiudadService{

    @Autowired
    private ICiudadRepository repo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Ciudad addCiudad(CiudadRequestDto ciudad) {
        Ciudad ciudad1 = modelMapper.map(ciudad, Ciudad.class);

        return repo.save(ciudad1);
    }

    @Override
    public Ciudad modficarCiudad(CiudadRequestDto ciudad) {
        Ciudad ciudad1 = modelMapper.map(ciudad, Ciudad.class);

        return repo.save(ciudad1);
    }

    @Override
    public void deleteCiudad(CiudadRequestDto ciudad) {

        Ciudad ciudad1 = modelMapper.map(ciudad, Ciudad.class);

        repo.delete(ciudad1);
    }

    @Override
    public List<CiudadResponseDto> findAll() {
         List <Ciudad> list = repo.findAll();

         return list.stream().map(l -> modelMapper.map(l, CiudadResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CiudadResponseDto> findCiudadByNombre(String nombre) {
        List <Ciudad> list = repo.findCiudadByNombre(nombre);

        return list.stream().map(l -> modelMapper.map(l, CiudadResponseDto.class)).collect(Collectors.toList());
    }
}
