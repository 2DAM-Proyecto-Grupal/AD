package org.example.proyecto_nomadas.controller;
import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.service.IResenyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.proyecto_nomadas.model.Resenya;
import org.example.proyecto_nomadas.model.Usuario;
import java.util.List;

@RestController
@RequestMapping("/reseña")
public class ResenyaController {
    @Autowired
    private IResenyaService service;

    @GetMapping("/all")
    public ResponseEntity<List<Resenya>> findAll(){
        List<Resenya> lista = service.findAll();

        if (!lista.isEmpty()){

            return new ResponseEntity<>(lista, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<List<Resenya>> findByCiudad(@RequestBody Ciudad ciudad){
        List<Resenya> lista = service.findByCiudad(ciudad);

        if (!lista.isEmpty()){

            return new ResponseEntity<>(lista, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<Resenya>> findByUsuario(@RequestBody Usuario usuario){
        List<Resenya> lista = service.findByUsuario(usuario);
        if (!lista.isEmpty()){
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/addResenya")
    public Resenya addResenya(@RequestBody Resenya resenya){
        return service.addResenya(resenya);
    }

    @PutMapping("/modResenya")
    public Resenya modificarResenya(@RequestBody Resenya resenya){
        return service.modificarResenya(resenya);
    }

    @DeleteMapping("/deleteResenya/{resenya}")

    public void deleteResenya(@RequestBody Resenya resenya){
        service.deleteResenya(resenya);
    }





}
