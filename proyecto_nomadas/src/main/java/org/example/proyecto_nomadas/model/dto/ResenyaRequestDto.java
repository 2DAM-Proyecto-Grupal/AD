package org.example.proyecto_nomadas.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proyecto_nomadas.model.Ciudad;
import org.example.proyecto_nomadas.model.Lugar;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResenyaRequestDto {

    @NotNull
    private String titulo;

    @NotNull
    private String textoResenya;

    @Min(0)
    @Max(5)
    private Integer valoracion;

    @NotBlank
    private String fechaCreacion;

    private Ciudad ciudad;

    private Lugar lugar;

    private int uid_usuario;

    private String nombreUsuario;
}
