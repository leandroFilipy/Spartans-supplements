package com.suplements.spar.spartan.service;

import com.suplements.spar.spartan.dto.cupom.CupomRequest;
import com.suplements.spar.spartan.dto.cupom.CupomResponse;
import com.suplements.spar.spartan.mapper.CupomMapper;
import com.suplements.spar.spartan.model.Cupom;
import com.suplements.spar.spartan.repository.CupomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CupomService {

    private final CupomRepository cupomRepository;
    private final CupomMapper cupomMapper;

    public CupomResponse create(CupomRequest cupomRequest){

        Cupom cupom = cupomMapper.toEntity(cupomRequest);
        Cupom cupomSalvo = cupomRepository.save(cupom);
        CupomResponse cupomResponse = cupomMapper.toResponse(cupomSalvo);

        return cupomResponse;
    }

    public List<CupomResponse> list (){

        List<Cupom> cupoms = cupomRepository.findAll();
        List<CupomResponse> dto = new ArrayList<>();

        for(Cupom c : cupoms){
            dto.add(cupomMapper.toResponse(c));
        }

        return dto;
    }

    public CupomResponse listById(long id){

        Cupom cupom = cupomRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no coupon which ID is " + id));
        CupomResponse cupomResponse = cupomMapper.toResponse(cupom);

        return cupomResponse;
    }

    public CupomResponse update (long id, CupomRequest cupomRequest){

        Cupom cupom = cupomRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no coupon which ID is " + id));
        cupom.setCodigo(cupomRequest.codigo());
        cupom.setPorcentagemDesconto(cupomRequest.porcentagemDesconto());
        cupom.setAtivo(cupomRequest.ativo());
        Cupom cupomSalvo = cupomRepository.save(cupom);
        CupomResponse cupomResponse = cupomMapper.toResponse(cupomSalvo);

        return cupomResponse;
    }

    public void delete(long id){
        if(cupomRepository.existsById(id)){
            cupomRepository.deleteById(id);
        }else {
            new RuntimeException("There is no coupon which ID is " + id);
        }
    }
}
