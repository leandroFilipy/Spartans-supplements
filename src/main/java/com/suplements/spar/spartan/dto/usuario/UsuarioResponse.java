package com.suplements.spar.spartan.dto.usuario;

import java.time.LocalDate;

public record UsuarioResponse(
        long id,
        String nome,
        String email,
        String password,
        String telefone,
        String endereco,
        String cpf,
        LocalDate dataNascimento
) {
}
