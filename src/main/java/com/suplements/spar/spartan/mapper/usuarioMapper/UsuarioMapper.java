package com.suplements.spar.spartan.mapper.usuarioMapper;

import com.suplements.spar.spartan.dto.Usuario.UsuarioRequest;
import com.suplements.spar.spartan.dto.Usuario.UsuarioResponse;
import com.suplements.spar.spartan.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements IUsuarioMapper{

    @Override
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

    @Override
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
