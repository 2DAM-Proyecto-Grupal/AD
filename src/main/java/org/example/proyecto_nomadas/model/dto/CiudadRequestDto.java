package org.example.proyecto_nomadas.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiudadRequestDto {

    @NotNull
    private String nombre;

    @NotBlank
    private String pais;

    @Size(min = 1, max = 20, message = "El código postal debe tener en uno y veinte caracteres.")
    private String codigoPostal;

    @NotBlank
    private String region;


}
