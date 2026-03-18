package com.suplements.spar.spartan.service;

import com.suplements.spar.spartan.dto.Usuario.UsuarioRequest;
import com.suplements.spar.spartan.dto.Usuario.UsuarioResponse;
import com.suplements.spar.spartan.mapper.UsuarioMapper;
import com.suplements.spar.spartan.model.Usuario;
import com.suplements.spar.spartan.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioResponse create(UsuarioRequest dto){
        Usuario user = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(user));
    }

    public UsuarioResponse listById(long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Id invalido!")));
    }

    public UsuarioResponse update(long id, UsuarioRequest dto){
        Usuario user = repository.findById(id).orElseThrow(() -> new RuntimeException("Id invalido!"));

        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setTelefone(dto.telefone());
        user.setEndereco(dto.endereco());
        user.setCpf(dto.cpf());
        user.setDataNascimento(dto.dataNascimento());

        return mapper.toResponse(repository.save(user));
    }

    public String delete(long id){
        Usuario user = repository.findById(id).orElseThrow(() -> new RuntimeException("Id invalido!"));
        repository.delete(user);
        return "Usuario deletado com sucesso!";
    }
}
