package com.suplements.spar.spartan.dto.Usuario;

public record UsuarioRequest(
        String nome,
        String email,
        String password,
        String telefone,
        String endereco,
        String cpf
) {
}
