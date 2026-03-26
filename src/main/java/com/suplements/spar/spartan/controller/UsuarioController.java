package com.suplements.spar.spartan.controller;

import com.suplements.spar.spartan.dto.Usuario.UsuarioLoginRequest;
import com.suplements.spar.spartan.dto.Usuario.UsuarioRequest;
import com.suplements.spar.spartan.dto.Usuario.UsuarioResponse;
import com.suplements.spar.spartan.service.usuarioService.IUsuarioService;
import com.suplements.spar.spartan.service.usuarioService.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService iUsuarioService;

    @GetMapping("/list/{id}")
    public UsuarioResponse listById(@PathVariable long id) {
        return iUsuarioService.listById(id);
    }

    @PostMapping("/register")
    public UsuarioResponse create(@Valid @RequestBody UsuarioRequest dto) {
        return iUsuarioService.create(dto);
    }

    @PutMapping("/update/{id}")
    public UsuarioResponse update(@Valid @PathVariable long id, @RequestBody UsuarioRequest dto) {
        return iUsuarioService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        iUsuarioService.delete(id);
    }

    @GetMapping("/login")
    public boolean userExists(@RequestBody UsuarioLoginRequest usuarioLoginRequest) {
        return iUsuarioService.userExistsByEmailAndPassword(usuarioLoginRequest);
    }
}

