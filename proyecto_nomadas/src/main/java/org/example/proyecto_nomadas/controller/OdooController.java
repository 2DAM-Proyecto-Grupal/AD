package org.example.proyecto_nomadas.controller;

import org.example.proyecto_nomadas.service.OdooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/odoo")
public class OdooController {

    @Autowired
    private OdooService odooService;


    @PostMapping("/login/{nombre}/{pass}")
    public Object login(@PathVariable ("nombre") String username, @PathVariable ("pass") String password) {
        String url = "http://192.168.8.110:8069/jsonrpc";
        String db = "Proyecto";
        return odooService.loginEnOdoo(url, db, username, password);
    }

    @PostMapping("/user/{id}")
    public Object getInfo(@PathVariable ("id") int id) {
        String url = "http://192.168.8.110:8069/jsonrpc";
        return odooService.getInfo(url, id);
    }

    @PostMapping("/venta/{id_user}")
    public Object crearVenta(@PathVariable("id_user") int id_user) {
        String url = "http://192.168.8.110:8069/jsonrpc";
        String db = "Proyecto";
        String username = "Juan";
        String password = "1234";
        return odooService.crearVenta(url, db,2, "admin", id_user);
    }

}
