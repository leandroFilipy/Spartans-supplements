package com.suplements.spar.spartan.controller;

import com.suplements.spar.spartan.dto.cupom.CupomRequest;
import com.suplements.spar.spartan.dto.cupom.CupomResponse;
import com.suplements.spar.spartan.service.cupomService.CupomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
public class CupomController {

    private final CupomService cupomService;


    @PostMapping("/register")
    public CupomResponse create(@Valid @RequestBody CupomRequest cupomRequest){
            return cupomService.create(cupomRequest);
    }

    @GetMapping("/list")
    public List<CupomResponse> list(){
            return cupomService.list();
    }

    @GetMapping("/list/{id}")
    public CupomResponse listById(@PathVariable long id){
            return cupomService.listById(id);
    }

    @PutMapping("/update/{id}")
    public CupomResponse update (@Valid @PathVariable long id, @RequestBody CupomRequest cupomRequest){
            return cupomService.update(id, cupomRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable long id){
            cupomService.delete(id);
    }

}
