package com.suplements.spar.spartan.mapper.cupomMapper;

import com.suplements.spar.spartan.dto.cupom.CupomRequest;
import com.suplements.spar.spartan.dto.cupom.CupomResponse;
import com.suplements.spar.spartan.model.Cupom;
import org.springframework.stereotype.Component;

@Component
public class CupomMapper implements ICupomMapper{

    @Override
    public Cupom toEntity (CupomRequest cupomRequest){

        return new Cupom(
                cupomRequest.codigo(),
                cupomRequest.porcentagemDesconto(),
                cupomRequest.ativo()
        );
    }

    @Override
    public CupomResponse toResponse(Cupom cupom){

        return new CupomResponse(
                cupom.getId(),
                cupom.getCodigo(),
                cupom.getPorcentagemDesconto(),
                cupom.isAtivo()
        );
    }

}
