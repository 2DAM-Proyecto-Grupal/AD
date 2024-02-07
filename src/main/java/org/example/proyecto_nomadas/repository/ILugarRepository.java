package org.example.proyecto_nomadas.repository;
import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILugarRepository extends JpaRepository<Lugar, Integer> {

    List<Lugar> findAll();
    List<Lugar> findLugarByNombre(String nombre);
}
