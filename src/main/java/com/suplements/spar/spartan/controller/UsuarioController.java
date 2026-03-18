package com.suplements.spar.spartan.controller;

import com.suplements.spar.spartan.dto.Usuario.UsuarioRequest;
import com.suplements.spar.spartan.dto.Usuario.UsuarioResponse;
import com.suplements.spar.spartan.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/list/{id}")
    public UsuarioResponse listById(@PathVariable long id){
        return service.listById(id);
    }

    @PostMapping("/create")
    public UsuarioResponse create (@RequestBody UsuarioRequest dto){
        return service.create(dto);
    }

    @PutMapping("/update/{id}")
    public UsuarioResponse update(@PathVariable long id, @RequestBody UsuarioRequest dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        return service.delete(id);
    }
}
