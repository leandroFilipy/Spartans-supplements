package com.suplements.spar.spartan.service.usuarioService;

import com.suplements.spar.spartan.dto.usuario.UsuarioLoginRequest;
import com.suplements.spar.spartan.dto.usuario.UsuarioRequest;
import com.suplements.spar.spartan.dto.usuario.UsuarioResponse;

public interface IUsuarioService {

    UsuarioResponse create(UsuarioRequest usuarioRequest);
    UsuarioResponse listById(long id);
    UsuarioResponse update(long id, UsuarioRequest usuarioRequest);
    void delete(long id);
    boolean userExistsByEmailAndPassword(UsuarioLoginRequest usuarioLoginRequest);
}
