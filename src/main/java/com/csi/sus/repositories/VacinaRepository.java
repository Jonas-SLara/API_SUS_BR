package com.csi.sus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csi.sus.model.vacina.Vacina;

@Repository
public interface VacinaRepository extends
        JpaRepository<Vacina, Long>{

    //buscar vacina por nome
    Optional<Vacina> findByNome(String nome);
}
