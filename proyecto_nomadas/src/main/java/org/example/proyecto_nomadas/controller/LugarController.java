package org.example.proyecto_nomadas.controller;

import jakarta.validation.Valid;
import org.example.proyecto_nomadas.model.Lugar;
import org.example.proyecto_nomadas.model.dto.LugarRequestDto;
import org.example.proyecto_nomadas.model.dto.LugarResponseDto;
import org.example.proyecto_nomadas.service.ILugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lugares")
public class LugarController {
    @Autowired
    private ILugarService service;

    @GetMapping
    public ResponseEntity<List<LugarResponseDto>> findAll() {
        List<LugarResponseDto> lista = service.findAll();


        if (!lista.isEmpty()){
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<LugarResponseDto>> findLugarByNombre(@PathVariable String nombre) {

        List<LugarResponseDto> lista = service.findLugarByNombre(nombre);


        if (!lista.isEmpty()){
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLugar(@Valid @RequestBody LugarRequestDto lugar) {
        service.deleteLugar(lugar);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addLugar(@Valid @RequestBody LugarRequestDto lugar) {
        Lugar sitio = service.addLugar(lugar);

        if (sitio != null){
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Void> modficarLugar(@Valid @RequestBody LugarRequestDto lugar) {

        Lugar sitio = service.modficarLugar(lugar);

        if (sitio != null){
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
