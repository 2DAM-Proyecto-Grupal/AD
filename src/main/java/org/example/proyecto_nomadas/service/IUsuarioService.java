package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    Usuario addUsuario(Usuario usuario);
    Usuario modficarUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
    List<Usuario> findAll();
    List<Usuario> findUsuarioByNombre(String nombre);
}
