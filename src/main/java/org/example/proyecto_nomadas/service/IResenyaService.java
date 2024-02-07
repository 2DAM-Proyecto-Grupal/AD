package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Resenya;
import org.example.proyecto_nomadas.model.Usuario;

import java.util.List;

public interface IResenyaService {
    Resenya addResenya (Resenya resenya);
    Resenya modificarResenya (Resenya resenya);
    void deleteResenya (Resenya resenya);
    List<Resenya> findAll();
    List<Resenya> findByCiudad(Ciudad ciudad);
    List<Resenya> findByUsuario(Usuario usuario);
}
