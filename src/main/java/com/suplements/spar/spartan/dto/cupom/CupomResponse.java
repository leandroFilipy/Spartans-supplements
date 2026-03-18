package com.suplements.spar.spartan.dto.cupom;

public record CupomResponse (

        long id,
        String codigo,
        double porcentagemDesconto,
        boolean ativo
){
}
