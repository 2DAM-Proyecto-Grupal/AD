package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Resenya;
import org.example.proyecto_nomadas.model.Usuario;
import org.example.proyecto_nomadas.model.dto.CiudadRequestDto;
import org.example.proyecto_nomadas.model.dto.ResenyaRequestDto;
import org.example.proyecto_nomadas.model.dto.ResenyaResponseDto;
import org.example.proyecto_nomadas.model.dto.UsuarioRequestDto;
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
        Resenya res = modelMapper.map(resenya, Resenya.class);

        return repo.save(res);
    }

    @Override
    public Resenya modificarResenya(ResenyaRequestDto resenya) {
        Resenya res = modelMapper.map(resenya, Resenya.class);

        return repo.save(res);
    }

    @Override
    public void deleteResenya(ResenyaRequestDto resenya) {
        Resenya res = modelMapper.map(resenya, Resenya.class);

        repo.delete(res);
    }

    @Override
    public List<ResenyaResponseDto> findAll() {
        List<Resenya> lista = repo.findAll();

        return lista.stream().map(l-> modelMapper.map(l,ResenyaResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ResenyaResponseDto> findByCiudad(CiudadRequestDto ciudad) {
        Ciudad ciu = modelMapper.map(ciudad,Ciudad.class);
        List<Resenya> lista = repo.findByCiudad(ciu);

        return lista.stream().map(l-> modelMapper.map(l,ResenyaResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ResenyaResponseDto> findByUsuario(UsuarioRequestDto usuario) {
        Usuario usu = modelMapper.map(usuario, Usuario.class);
        List<Resenya> lista = repo.findByUsuario(usu);

        return lista.stream().map(l-> modelMapper.map(l,ResenyaResponseDto.class)).collect(Collectors.toList());
    }
}
