package com.suplements.spar.spartan.dto.Usuario;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record UsuarioResponse(
        long id,
        String nome,
        String email,
        String password,
        String telefone,
        String endereco,
        String cpf

) {
}
