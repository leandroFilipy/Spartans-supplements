package com.suplements.spar.spartan.service.cupomService;

import com.suplements.spar.spartan.dto.cupom.CupomRequest;
import com.suplements.spar.spartan.dto.cupom.CupomResponse;
import com.suplements.spar.spartan.mapper.cupomMapper.ICupomMapper;
import com.suplements.spar.spartan.model.Cupom;
import com.suplements.spar.spartan.repository.CupomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CupomService implements ICupomService{

    private final CupomRepository cupomRepository;
    private final ICupomMapper iCupomMapper;

    @Override
    public CupomResponse create(CupomRequest cupomRequest){

        Cupom cupom = iCupomMapper.toEntity(cupomRequest);
        Cupom cupomSalvo = cupomRepository.save(cupom);
        CupomResponse cupomResponse = iCupomMapper.toResponse(cupomSalvo);

        return cupomResponse;
    }

    @Override
    public List<CupomResponse> list (){

        List<Cupom> cupoms = cupomRepository.findAll();
        List<CupomResponse> dto = new ArrayList<>();

        for(Cupom c : cupoms){
            dto.add(iCupomMapper.toResponse(c));
        }

        return dto;
    }

    @Override
    public CupomResponse listById(long id){

        Cupom cupom = cupomRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no coupon which ID is " + id));
        CupomResponse cupomResponse = iCupomMapper.toResponse(cupom);

        return cupomResponse;
    }

    @Override
    public CupomResponse update (long id, CupomRequest cupomRequest){

        Cupom cupom = cupomRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no coupon which ID is " + id));
        cupom.setCodigo(cupomRequest.codigo());
        cupom.setPorcentagemDesconto(cupomRequest.porcentagemDesconto());
        cupom.setAtivo(cupomRequest.ativo());
        Cupom cupomSalvo = cupomRepository.save(cupom);
        CupomResponse cupomResponse = iCupomMapper.toResponse(cupomSalvo);

        return cupomResponse;
    }

    @Override
    public void delete(long id){
        if(cupomRepository.existsById(id)){
            cupomRepository.deleteById(id);
        }else {
            new RuntimeException("There is no coupon which ID is " + id);
        }
    }
}
