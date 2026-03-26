package com.suplements.spar.spartan.mapper.usuarioMapper;

import com.suplements.spar.spartan.dto.Usuario.UsuarioRequest;
import com.suplements.spar.spartan.dto.Usuario.UsuarioResponse;
import com.suplements.spar.spartan.model.Usuario;

public interface IUsuarioMapper {

    Usuario toEntity (UsuarioRequest usuarioRequest);
    UsuarioResponse toResponse(Usuario usuario);

}
