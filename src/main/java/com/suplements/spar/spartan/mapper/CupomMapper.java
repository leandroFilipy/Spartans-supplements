package com.suplements.spar.spartan.mapper;

import com.suplements.spar.spartan.dto.cupom.CupomRequest;
import com.suplements.spar.spartan.dto.cupom.CupomResponse;
import com.suplements.spar.spartan.model.Cupom;
import org.springframework.stereotype.Component;

@Component
public class CupomMapper {

    public Cupom toEntity (CupomRequest cupomRequest){

        return new Cupom(
                cupomRequest.codigo(),
                cupomRequest.porcentagemDesconto(),
                cupomRequest.ativo()
        );
    }

    public CupomResponse toResponse(Cupom cupom){

        return new CupomResponse(
                cupom.getId(),
                cupom.getCodigo(),
                cupom.getPorcentagemDesconto(),
                cupom.isAtivo()
        );
    }

}
