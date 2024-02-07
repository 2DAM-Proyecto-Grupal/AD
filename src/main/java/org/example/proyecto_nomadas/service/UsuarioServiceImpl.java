package org.example.proyecto_nomadas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.proyecto_nomadas.repository.IUsuarioRepository;
import org.example.proyecto_nomadas.model.Usuario;
import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    @Autowired
    private IUsuarioRepository repo;

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Usuario> findUsuarioByNombre(String nombre) {
        return repo.findUsuarioByNombre(nombre);
    }

    @Override
    public Usuario addUsuario(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public Usuario modficarUsuario(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        repo.delete(usuario);
    }

}
