package com.csi.sus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csi.sus.model.doenca.Doenca;

@Repository
public interface DoencaRepository extends
        JpaRepository<Doenca, Long>{

    //buscar doenca pelo nome
    Optional<Doenca> findByNome(String nome);
}
