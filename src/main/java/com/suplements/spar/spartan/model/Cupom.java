package com.suplements.spar.spartan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cupom")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private double porcentagemDesconto;

    @Column(nullable = false)
    private boolean ativo;

    public Cupom(String codigo, double porcentagemDesconto, boolean ativo) {
        this.codigo = codigo;
        this.porcentagemDesconto = porcentagemDesconto;
        this.ativo=ativo;
    }
}
