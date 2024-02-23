package org.example.proyecto_nomadas.controller;
import jakarta.validation.Valid;
import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Lugar;
import org.example.proyecto_nomadas.model.dto.ResenyaRequestDto;
import org.example.proyecto_nomadas.model.dto.ResenyaResponseDto;
import org.example.proyecto_nomadas.service.IResenyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.proyecto_nomadas.model.Resenya;

import java.util.List;

@RestController
@RequestMapping("/reseñas")
public class ResenyaController {
    @Autowired
    private IResenyaService service;

    @GetMapping()
    public ResponseEntity<List<ResenyaResponseDto>> findAll(){
        List<ResenyaResponseDto> lista = service.findAll();

        if (!lista.isEmpty()){

            return new ResponseEntity<>(lista, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<List<ResenyaResponseDto>> findByCiudad(@PathVariable("ciudad") Ciudad ciudad){
        List<ResenyaResponseDto> lista = service.findByCiudad(ciudad);

        if (!lista.isEmpty()){

            return new ResponseEntity<>(lista, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/lugar/{lugar}")
    public ResponseEntity<List<ResenyaResponseDto>> findByLugar(@PathVariable("lugar") Lugar lugar){
        List<ResenyaResponseDto> lista = service.findByLugar(lugar);

        if (!lista.isEmpty()){

            return new ResponseEntity<>(lista, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping()
    public Resenya addResenya(@Valid @RequestBody ResenyaRequestDto resenya){
        return service.addResenya(resenya);
    }

    @PutMapping("/modResenya")
    public Resenya modificarResenya(@Valid @RequestBody ResenyaRequestDto resenya){
        return service.modificarResenya(resenya);
    }

    @DeleteMapping("/deleteResenya/{resenya}")

    public void deleteResenya(@Valid @RequestBody Resenya resenya){
        service.deleteResenya(resenya);
    }

}
