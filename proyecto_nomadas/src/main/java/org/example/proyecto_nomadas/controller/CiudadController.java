package org.example.proyecto_nomadas.controller;

import jakarta.validation.Valid;
import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.dto.CiudadRequestDto;
import org.example.proyecto_nomadas.model.dto.CiudadResponseDto;
import org.example.proyecto_nomadas.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudades")

public class CiudadController {
    @Autowired
    private ICiudadService service;

    @GetMapping
    public ResponseEntity<List<CiudadResponseDto>> findAll(){
        List<CiudadResponseDto> lista = service.findAll();

        if (!lista.isEmpty()){
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<CiudadResponseDto>> findCiudadByNombre(@PathVariable String nombre){
        List<CiudadResponseDto> lista = service.findCiudadByNombre(nombre);

        if (!lista.isEmpty()){
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCiudad(@Valid @RequestBody CiudadRequestDto ciudad){
      service.deleteCiudad(ciudad);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addCiudad(@Valid @RequestBody CiudadRequestDto ciudad){
        Ciudad ciudad1 = service.addCiudad(ciudad);

        if (ciudad1 != null){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Void> modficarCiudad(@Valid @RequestBody CiudadRequestDto ciudad){
        Ciudad ciudad1 = service.modficarCiudad(ciudad);

        if (ciudad1 != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
