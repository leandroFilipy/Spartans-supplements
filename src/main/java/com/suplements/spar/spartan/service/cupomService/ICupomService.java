package com.suplements.spar.spartan.service.cupomService;

import com.suplements.spar.spartan.dto.cupom.CupomRequest;
import com.suplements.spar.spartan.dto.cupom.CupomResponse;

import java.util.List;

public interface ICupomService {

    CupomResponse create(CupomRequest cupomRequest);
    List<CupomResponse> list();
    CupomResponse listById(long id);
    CupomResponse update(long id, CupomRequest cupomRequest);
    void delete(long id);

}
