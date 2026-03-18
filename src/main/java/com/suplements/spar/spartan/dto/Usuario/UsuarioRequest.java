package com.suplements.spar.spartan.dto.Usuario;

import java.time.LocalDate;

public record UsuarioRequest(
        String nome,
        String email,
        String password,
        String telefone,
        String endereco,
        String cpf,
        LocalDate dataNascimento
) {
}
