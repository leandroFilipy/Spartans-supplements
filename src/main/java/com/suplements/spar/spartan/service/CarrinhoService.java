package com.suplements.spar.spartan.service;


import com.suplements.spar.spartan.model.Carrinho;
import com.suplements.spar.spartan.model.ItemCarrinho;
import com.suplements.spar.spartan.model.Produto;
import com.suplements.spar.spartan.model.Usuario;
import com.suplements.spar.spartan.repository.CarrinhoRepository;
import com.suplements.spar.spartan.repository.ItemCarrinhoRepository;
import com.suplements.spar.spartan.repository.ProdutoRepository;
import com.suplements.spar.spartan.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarrinhoService {

    private final CarrinhoRepository repository;
    private final ItemCarrinhoRepository itemRepository;
    private final UsuarioRepository userRepository;
    private final ProdutoRepository produtoRepository;

    public Carrinho createCart(Long id){
        Carrinho carrinho = new Carrinho();
        carrinho.setUsuario(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado!!!")));
        carrinho.setItens(new ArrayList<>());
        carrinho.setTotal(0.0);

        return repository.save(carrinho);
    }

    public Carrinho addProduct(Long carrinhoId, long idProduto , int quantidade){

        Carrinho carrinho = repository.findById(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado!!!"));

        ItemCarrinho item = new ItemCarrinho();
        item.setCarrinho(carrinho);
        item.setProduto(produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("There is no product with this ID")));
        item.setQuantidade(quantidade);

        carrinho.getItens().add(item);

        double total = calcularTotal(carrinho);

        carrinho.setTotal(total);
        return repository.save(carrinho);
    }

    public Carrinho removeProduct(Long carrinhoId, Long itemId){
        Carrinho carrinho = repository.findById(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        for (ItemCarrinho item : carrinho.getItens()) {
            if (item.getId().equals(itemId)) {
                carrinho.getItens().remove(item);
                itemRepository.deleteById(itemId);
                break;
            }
        };

        double total = calcularTotal(carrinho);

        carrinho.setTotal(total);
        return repository.save(carrinho);
    }

    private double calcularTotal(Carrinho carrinho){
        return carrinho.getItens().stream()
                .mapToDouble(i -> i.getProduto().getPreco() * i.getQuantidade())
                .sum();
    }


}
