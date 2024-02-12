package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.JsonRpcRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;



@Service
public class OdooService {

    public Object loginEnOdoo(String url, String db, String username, String password) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Construir los argumentos y parámetros específicos para el método de login

        Map<String, Object> args = new HashMap<>();
        args.put("service", "common");
        args.put("method", "login");
        args.put("args", new Object[]{db, username, password});

        JsonRpcRequest request = new JsonRpcRequest("call", args, 264030578);

        // System.out.println(request.toString());

        HttpEntity<JsonRpcRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForObject(url, entity, Object.class);
    }

}
