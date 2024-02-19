package org.example.proyecto_nomadas.repository;

import org.example.proyecto_nomadas.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenRepository extends JpaRepository<Imagen, Long> {
}
