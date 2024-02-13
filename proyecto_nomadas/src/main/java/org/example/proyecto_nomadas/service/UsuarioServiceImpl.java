package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.dto.UsuarioRequestDto;
import org.example.proyecto_nomadas.model.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.proyecto_nomadas.repository.IUsuarioRepository;
import org.example.proyecto_nomadas.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UsuarioResponseDto> findAll() {
        List<Usuario> listaUsuarios = repo.findAll();
        return listaUsuarios.stream().map(usuarios -> modelMapper.map(usuarios, UsuarioResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioResponseDto> findUsuarioByNombre(String nombre) {
        List<Usuario> listaUsuarios = repo.findAll();
        return listaUsuarios.stream().map(usuarios -> modelMapper.map(usuarios, UsuarioResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public Usuario addUsuario(UsuarioRequestDto usuario) {
        Usuario usuarioDto = modelMapper.map(usuario, Usuario.class);
        return repo.save(usuarioDto);
    }

    @Override
    public Usuario modficarUsuario(UsuarioRequestDto usuario) {
        Usuario usuarioDto = modelMapper.map(usuario, Usuario.class);
        return repo.save(usuarioDto);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        repo.delete(usuario);
    }

}
