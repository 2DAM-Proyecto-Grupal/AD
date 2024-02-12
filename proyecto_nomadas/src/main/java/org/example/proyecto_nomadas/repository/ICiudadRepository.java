package org.example.proyecto_nomadas.repository;
import org.example.proyecto_nomadas.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {
    List<Ciudad> findCiudadByNombre(String nombre);
    List<Ciudad> findAll();

}
