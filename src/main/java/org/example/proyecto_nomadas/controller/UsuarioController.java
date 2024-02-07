package org.example.proyecto_nomadas.controller;


import org.example.proyecto_nomadas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.proyecto_nomadas.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> lista = service.findAll();
        if (lista.isEmpty()){
            return new ResponseEntity<>(lista,HttpStatus.NO_CONTENT);
        }else{
        return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<Usuario>> findUsuarioByNombre(@RequestParam String nombre) {
        List<Usuario> lista = service.findUsuarioByNombre(nombre);
        if (lista.isEmpty()){
            return new ResponseEntity<>(lista,HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

    @PostMapping("/add/{nombre}")
    public ResponseEntity<Void> addUsuario(@RequestBody Usuario usuario) {
        Usuario usuario1 = service.addUsuario(usuario);
        if (usuario1 == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    @PutMapping("/mod/{nombre}")
    public ResponseEntity<Void> modficarUsuario(@RequestBody Usuario usuario) {
        Usuario usuario1 = service.modficarUsuario(usuario);
        if (usuario1 == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping(("/delete/{nombre}"))
    public ResponseEntity<Void> deleteUsuario(@RequestBody Usuario usuario) {
        service.deleteUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}