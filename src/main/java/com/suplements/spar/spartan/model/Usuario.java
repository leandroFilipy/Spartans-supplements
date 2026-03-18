package com.suplements.spar.spartan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String nome;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String password;
    String telefone;
    String endereco;
    @Column(nullable = false)
    String cpf;
    LocalDate dataNascimento;

}
