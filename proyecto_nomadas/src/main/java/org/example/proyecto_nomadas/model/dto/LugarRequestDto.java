package org.example.proyecto_nomadas.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proyecto_nomadas.model.Ciudad;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LugarRequestDto {

    @NotNull
    private String nombre;

    @Size(min = 1, max = 60, message = "El lugar debe tener entre 1 y 60 caracteres.")
    private String tipo;

    @Size(min = 5, max = 100, message = "La dirección debe tener entre 5 y 100 caracteres.")
    private String direccion;


    private String informacionContacto;

    private Ciudad ciudad;


}
