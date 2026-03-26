package com.suplements.spar.spartan.repository;

import com.suplements.spar.spartan.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmailAndPassword(String email, String password);
}
