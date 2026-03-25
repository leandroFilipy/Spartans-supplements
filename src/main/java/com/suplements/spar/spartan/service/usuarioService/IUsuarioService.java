package com.suplements.spar.spartan.service.usuarioService;

import com.suplements.spar.spartan.dto.Usuario.UsuarioRequest;
import com.suplements.spar.spartan.dto.Usuario.UsuarioResponse;
import com.suplements.spar.spartan.model.Usuario;

public interface IUsuarioService {

    UsuarioResponse create(UsuarioRequest usuarioRequest);
    UsuarioResponse listById(long id);
    UsuarioResponse update(long id, UsuarioRequest usuarioRequest);
    void delete(long id);
}
