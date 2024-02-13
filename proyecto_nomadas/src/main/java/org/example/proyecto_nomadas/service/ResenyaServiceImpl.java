package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Resenya;
import org.example.proyecto_nomadas.model.Usuario;
import org.example.proyecto_nomadas.model.dto.ResenyaRequestDto;
import org.example.proyecto_nomadas.model.dto.ResenyaResponseDto;
import org.example.proyecto_nomadas.repository.IResenyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResenyaServiceImpl implements IResenyaService{

    @Autowired
    private IResenyaRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Resenya addResenya(ResenyaRequestDto resenya) {
        Resenya resenyaDto = modelMapper.map(resenya, Resenya.class);
        return repo.save(resenyaDto);
    }

    @Override
    public Resenya modificarResenya(ResenyaRequestDto resenya) {
        Resenya resenyaDto = modelMapper.map(resenya, Resenya.class);
        return repo.save(resenyaDto);
    }

    @Override
    public void deleteResenya(Resenya resenya) {
        repo.delete(resenya);
    }

    @Override
    public List<ResenyaResponseDto> findAll() {
        List<Resenya> listaResenyas = repo.findAll();
        return listaResenyas.stream().map(lista -> modelMapper.map(lista , ResenyaResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ResenyaResponseDto> findByCiudad(Ciudad ciudad) {
        List<Resenya> resenyaCiudad = repo.findByCiudad(ciudad);
        return resenyaCiudad.stream().map(resenyas -> modelMapper.map(resenyas, ResenyaResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ResenyaResponseDto> findByUsuario(Usuario usuario) {
        List<Resenya> resenyaUsuario = repo.findByUsuario(usuario);
        return resenyaUsuario.stream().map(usuarios -> modelMapper.map(usuarios, ResenyaResponseDto.class)).collect(Collectors.toList());
    }
}
