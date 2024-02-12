package org.example.proyecto_nomadas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JsonRpcRequest {
    private String jsonrpc = "2.0";
    private String method;
    private Map<String, Object> params;
    private int id;

    // Constructor, getters y setters
    public JsonRpcRequest(String method, Map<String, Object> params, int id) {
        this.method = method;
        this.params = params;
        this.id = id;
    }


}
