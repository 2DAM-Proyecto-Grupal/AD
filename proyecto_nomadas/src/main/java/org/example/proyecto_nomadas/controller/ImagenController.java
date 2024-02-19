package org.example.proyecto_nomadas.controller;

import org.example.proyecto_nomadas.model.Imagen;
import org.example.proyecto_nomadas.model.dto.ImagenDto;
import org.example.proyecto_nomadas.repository.IImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<byte[]> getAll() {
        List<Imagen> imagenes = repo.findAll();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            for (Imagen imagen : imagenes) {
                outputStream.write(imagen.getData());
            }

            byte[] allImageData = outputStream.toByteArray();

            if (allImageData.length > 0) {
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(allImageData);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }







    @GetMapping("/allId")
    public List<Long> getAllId() {
        List<Imagen> imagenes = repo.findAll();
        List<Long> ids = new ArrayList<>();

        for (Imagen imagen : imagenes) {
            ids.add(imagen.getId());
        }

        return ids;
    }


    @DeleteMapping("/delete/all")
    public void deleteAll() {
        repo.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

