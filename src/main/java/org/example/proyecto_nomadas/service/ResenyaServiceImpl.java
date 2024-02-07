package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Resenya;
import org.example.proyecto_nomadas.model.Usuario;
import org.example.proyecto_nomadas.repository.IResenyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenyaServiceImpl implements IResenyaService{

    @Autowired
    private IResenyaRepository repo;

    @Override
    public Resenya addResenya(Resenya resenya) {
        return repo.save(resenya);
    }

    @Override
    public Resenya modificarResenya(Resenya resenya) {
        return repo.save(resenya);
    }

    @Override
    public void deleteResenya(Resenya resenya) {
        repo.delete(resenya);
    }

    @Override
    public List<Resenya> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Resenya> findByCiudad(Ciudad ciudad) {
        return repo.findByCiudad(ciudad);
    }

    @Override
    public List<Resenya> findByUsuario(Usuario usuario) {
        return repo.findByUsuario(usuario);
    }
}
