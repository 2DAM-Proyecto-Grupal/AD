package org.example.proyecto_nomadas.controller;


import org.example.proyecto_nomadas.repository.IImagenRepository;
import org.example.proyecto_nomadas.model.Imagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    @Autowired
    private IImagenRepository repo;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Imagen imagen = new Imagen();
            imagen.setData(file.getBytes());
            repo.save(imagen);
            return ResponseEntity.status(HttpStatus.OK).body("Imagen cargada exitosamente.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cargar la imagen.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Imagen imagen = repo.findById(id).orElse(null);
        if (imagen != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


