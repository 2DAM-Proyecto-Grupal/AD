package org.example.proyecto_nomadas.repository;
import org.example.proyecto_nomadas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findAll();
    List<Usuario> findUsuarioByNombre(String nombre);

}
