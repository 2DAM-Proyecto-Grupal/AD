package org.example.proyecto_nomadas.repository;
import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Lugar;
import org.example.proyecto_nomadas.model.Resenya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IResenyaRepository extends JpaRepository<Resenya, Integer> {
    List<Resenya> findAll();
    List<Resenya> findByCiudad(Ciudad ciudad);

    List<Resenya> findByLugar(Lugar lugar);

}
