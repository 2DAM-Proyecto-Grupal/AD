package org.example.proyecto_nomadas.service;

import org.example.proyecto_nomadas.model.JsonRpcRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    public Object getInfo(String url, int id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> args = new HashMap<>();
        args.put("service", "object");
        args.put("method", "execute");
        args.put("args", new Object[]{"Proyecto", 2, "admin","res.users", "read",new Object[]{id}, new String[]{"name","login", "karma","is_premium"}});

        JsonRpcRequest request = new JsonRpcRequest("call", args, 2);
        HttpEntity<JsonRpcRequest> entity = new HttpEntity<>(request);

        return restTemplate.postForObject(url, entity, Object.class);
    }

    public Object crearVenta(String url, String db, int adminId, String adminPassword, int idUser) {
        //Busca si existe el producto y guarda su id
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> argsExisteProducto = new HashMap<>();
        argsExisteProducto.put("service", "object");
        argsExisteProducto.put("method", "execute");
        argsExisteProducto.put("args", new Object[]{db, adminId,adminPassword,"product.product", "search_read",new Object[]{},new String[]{"name"}});

        JsonRpcRequest requestExisteProducto = new JsonRpcRequest("call", argsExisteProducto, 2);
        HttpEntity<JsonRpcRequest> entityExisteProducto = new HttpEntity<>(requestExisteProducto);

        String jsonResponse = Objects.requireNonNull(restTemplate.postForObject(url, entityExisteProducto, Object.class)).toString();
        int productId = -1;
        String productoAComprar = "Servicio Premium";

        //Los Pattern son simplemente para que busque dentro del Json que devuelve Odoo para no hacer algo mas complicado para sacar la informacion
        Pattern productoPattern = Pattern.compile("id=(\\d+), name=([^,}]+)");
        Matcher matcher = productoPattern.matcher(jsonResponse);

        //Encuentra todas las coincidencias y almacena los valores en variables
        while (matcher.find()) {
            String id = matcher.group(1);
            String name = matcher.group(2);
            //Si encuentra la Subscripcion Premium guarda el id para generar la venta
            if (name.equalsIgnoreCase(productoAComprar)){
                productId = Integer.parseInt(id);
            }
        }
        if (productId != -1) {
            //Pilla el partner_id del res.users que lo solicita (para crear una venta se necesita en vez del user_id)
            Map<String, Object> argsEncontrarPartnerId = new HashMap<>();
            argsEncontrarPartnerId.put("service", "object");
            argsEncontrarPartnerId.put("method", "execute");

            argsEncontrarPartnerId.put("args", new Object[]{db, adminId, adminPassword, "res.users", "read",new Object[]{idUser},new String[]{"partner_id"}});

            JsonRpcRequest requestEncontrarPartnerId = new JsonRpcRequest("call", argsEncontrarPartnerId, 2);
            HttpEntity<JsonRpcRequest> entityEncontrarPartnerId = new HttpEntity<>(requestEncontrarPartnerId);

            jsonResponse = Objects.requireNonNull(restTemplate.postForObject(url, entityEncontrarPartnerId, Object.class)).toString();

            Pattern patternEncontrarPartnerId = Pattern.compile("partner_id=\\[([^\\]]+)]");
            matcher = patternEncontrarPartnerId.matcher(jsonResponse);

            int partnerId = -1;
            if (matcher.find()) {
                String[] numeros = matcher.group(1).split(",\\s*");
                if (numeros.length > 0) {
                    partnerId = Integer.parseInt(numeros[0]);
                }
            }
            if(partnerId!=-1) {
                //Crea la venta (vacia)
                Map<String, Object> argsCrearVenta = new HashMap<>();
                argsCrearVenta.put("service", "object");
                argsCrearVenta.put("method", "execute");
                //Se necesita copiar el id porque si no da error
                int finalPartnerId = partnerId;
                argsCrearVenta.put("args", new Object[]{db, adminId, adminPassword, "sale.order", "create", new Object[]{new HashMap<String, Object>() {{
                    put("partner_id", finalPartnerId);
                }}}});

                JsonRpcRequest requestCrearVenta = new JsonRpcRequest("call", argsCrearVenta, 123456789);
                HttpEntity<JsonRpcRequest> entityCrearVenta = new HttpEntity<>(requestCrearVenta);

                jsonResponse = Objects.requireNonNull(restTemplate.postForObject(url, entityCrearVenta, Object.class)).toString();

                Pattern idVentaPattern = Pattern.compile("\\[(\\d+)]");

                matcher = idVentaPattern.matcher(jsonResponse);

                int saleId = -1;

                while (matcher.find()) {
                    saleId = Integer.parseInt(matcher.group(1));
                }

                if (saleId != -1) {
                    //Añade un producto a la venta (la Subscripcion Premium, cantidad = 1)
                    Map<String, Object> argsProcesarVenta = new HashMap<>();
                    argsProcesarVenta.put("service", "object");
                    argsProcesarVenta.put("method", "execute");
                    //Se necesita copiar el id de las cosas porque si no da error
                    int finalProductId = productId;
                    int finalSaleId = saleId;
                    argsProcesarVenta.put("args", new Object[]{db, adminId, adminPassword, "sale.order.line", "create", new Object[]{new HashMap<String, Object>() {{
                        put("order_id", finalSaleId);
                        put("product_id", finalProductId);
                        put("product_uom_qty", 1);
                    }}}});

                    JsonRpcRequest requestProcesarVenta = new JsonRpcRequest("call", argsProcesarVenta, 123456789);
                    HttpEntity<JsonRpcRequest> entityProcesarVenta = new HttpEntity<>(requestProcesarVenta);

                    restTemplate.postForObject(url, entityProcesarVenta, Object.class);

                    Map<String, Object> argsConfirmarVenta = new HashMap<>();
                    argsConfirmarVenta.put("service", "object");
                    argsConfirmarVenta.put("method", "execute");
                    argsConfirmarVenta.put("args", new Object[]{db, adminId, adminPassword, "sale.order", "action_confirm", new Object[]{finalSaleId}});

                    JsonRpcRequest requestConfirmarVenta = new JsonRpcRequest("call", argsConfirmarVenta, 123456789);
                    HttpEntity<JsonRpcRequest> entityConfirmarVenta = new HttpEntity<>(requestConfirmarVenta);

                    //Como lo tenemos nosotros en Odoo al crear una venta automaticamente se aplica el Premium al Usuario
                    return restTemplate.postForObject(url, entityConfirmarVenta, Object.class);
                }
            }
            return null;
        }
        return null;
    }

}
