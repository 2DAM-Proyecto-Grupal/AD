package org.example.proyecto_nomadas.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioRequestDto {

    @NotNull
    private String nombre;

    @Email
    private String email;

    @Size(min = 8, message = "La longitud de la contraseña debe ser al menos 8 caracteres")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
            message = "La contraseña debe contener al menos una letra minúscula, una letra mayúscula, un número y un carácter especial"
    )
    private String contrasenya;


}
