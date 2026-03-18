package com.suplements.spar.spartan.dto.cupom;

import jakarta.persistence.Column;

public record CupomRequest (
       String codigo,
       double porcentagemDesconto,
       boolean ativo
){
}
