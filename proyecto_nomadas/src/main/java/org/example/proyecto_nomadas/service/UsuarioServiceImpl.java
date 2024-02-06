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
public class UsuarioServiceImpl implements IUsuarioService{
    @Autowired
    private IUsuarioRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UsuarioResponseDto> findAll() {
        List<Usuario> lista = repo.findAll();

        return lista.stream().map(l-> modelMapper.map(l, UsuarioResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioResponseDto> findUsuarioByNombre(String nombre) {
        List<Usuario> lista = repo.findUsuarioByNombre(nombre);

        return lista.stream().map(l-> modelMapper.map(l, UsuarioResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public Usuario addUsuario(UsuarioRequestDto usuario) {
        Usuario usu = modelMapper.map(usuario, Usuario.class);

        return repo.save(usu);
    }

    @Override
    public Usuario modficarUsuario(UsuarioRequestDto usuario) {
        Usuario usu = modelMapper.map(usuario, Usuario.class);

        return repo.save(usu);
    }

    @Override
    public void deleteUsuario(UsuarioRequestDto usuario) {
        Usuario usu = modelMapper.map(usuario, Usuario.class);

        repo.delete(usu);
    }

}
