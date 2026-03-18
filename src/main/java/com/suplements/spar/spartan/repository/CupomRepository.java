package com.suplements.spar.spartan.repository;

import com.suplements.spar.spartan.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends JpaRepository<Cupom,Long> {
}
