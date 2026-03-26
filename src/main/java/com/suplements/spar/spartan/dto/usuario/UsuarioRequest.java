package com.suplements.spar.spartan.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UsuarioRequest(

        @NotBlank(message = "The name field must not be empty")
        String nome,

        @Email(message = "The email field must be compatible")
        @NotBlank(message = "The email field must not be empty")

        String email,

        @Length(min = 6, message = "The password field must have at least 6 characteres")
        String password,

        @NotBlank(message = "The phone field must not be empty")
        String telefone,

        @NotBlank(message = "The address field must not be empty")
        String endereco,

        @CPF(message = "The cpf field must be compatible")
        String cpf,

        @Past(message = "The birth date must be in the past")
        LocalDate dataNascimento
) {
}
