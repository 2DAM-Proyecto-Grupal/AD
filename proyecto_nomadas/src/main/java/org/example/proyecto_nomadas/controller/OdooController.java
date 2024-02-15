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


    @PostMapping("/login")
    public Object login() {
        String url = "http://192.168.8.110:8069/jsonrpc";
        String db = "Proyecto";
        String username = "Juan";
        String password = "1234";
        return odooService.loginEnOdoo(url, db, username, password);
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
