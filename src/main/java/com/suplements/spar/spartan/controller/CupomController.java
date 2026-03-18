package com.suplements.spar.spartan.controller;

import com.suplements.spar.spartan.dto.cupom.CupomRequest;
import com.suplements.spar.spartan.dto.cupom.CupomResponse;
import com.suplements.spar.spartan.model.Cupom;
import com.suplements.spar.spartan.service.CupomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
public class CupomController {

    private final CupomService cupomService;


    @PostMapping("/register")
    public CupomResponse create (@RequestBody CupomRequest cupomRequest){
        try{
            return cupomService.create(cupomRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/list")
    public List<CupomResponse> list(){
        try{
            return cupomService.list();
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/list/{id}")
    public CupomResponse listById(@PathVariable long id){
        try{
            return cupomService.listById(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public CupomResponse update (@PathVariable long id, @RequestBody CupomRequest cupomRequest){
        try{
            return cupomService.update(id, cupomRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable long id){
        try{
            cupomService.delete(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
