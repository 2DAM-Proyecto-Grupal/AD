package org.example.proyecto_nomadas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResenyaResponseDto {


    private String textoReserva;


    private Integer valoracion;


    private LocalDate fechaCreacion;


}
