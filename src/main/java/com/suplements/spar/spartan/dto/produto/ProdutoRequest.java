package com.suplements.spar.spartan.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;

public record ProdutoRequest (

        @NotBlank(message = "This name field must not be empty")
        String nome,

        @Positive(message = "This price field must be positive")
        double preco,

        @Length(max = 399, message = "The description must be lower than 400 characters")
        String descricao,

        @Positive
        double peso,
        @Length(max = 99, message = "The description must be lower than 100 characters")
        @NotBlank(message = "This category field must not be empty")
        String categoria,
        String imagemUrl,

        @PositiveOrZero(message = "The stock must be posive or zero")
        int quantidadeEstoque

){
}
