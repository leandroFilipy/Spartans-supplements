package com.suplements.spar.spartan.mapper;

import com.suplements.spar.spartan.dto.Usuario.UsuarioRequest;
import com.suplements.spar.spartan.dto.Usuario.UsuarioResponse;
import com.suplements.spar.spartan.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequest dto){
        return new Usuario(
                dto.nome(),
                dto.email(),
                dto.password(),
                dto.telefone(),
                dto.endereco(),
                dto.cpf(),
                dto.dataNascimento()
        );
    }

    public UsuarioResponse toResponse(Usuario user){
        return new UsuarioResponse(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getPassword(),
                user.getTelefone(),
                user.getEndereco(),
                user.getCpf(),
                user.getDataNascimento()
        );
    }
}
