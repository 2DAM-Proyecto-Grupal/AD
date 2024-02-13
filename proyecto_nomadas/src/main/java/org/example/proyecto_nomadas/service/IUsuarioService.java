package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Usuario;
import org.example.proyecto_nomadas.model.dto.UsuarioRequestDto;
import org.example.proyecto_nomadas.model.dto.UsuarioResponseDto;

import java.util.List;

public interface IUsuarioService {
    Usuario addUsuario(UsuarioRequestDto usuarioRequestDto);
    Usuario modficarUsuario(UsuarioRequestDto usuarioRequestDto);
    void deleteUsuario(Usuario usuario);
    List<UsuarioResponseDto> findAll();
    List<UsuarioResponseDto> findUsuarioByNombre(String nombre);
}
