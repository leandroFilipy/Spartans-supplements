package com.suplements.spar.spartan.mapper.cupomMapper;

import com.suplements.spar.spartan.dto.cupom.CupomRequest;
import com.suplements.spar.spartan.dto.cupom.CupomResponse;
import com.suplements.spar.spartan.model.Cupom;

public interface ICupomMapper {

    Cupom toEntity(CupomRequest cupomRequest);
    CupomResponse toResponse(Cupom cupom);
}
