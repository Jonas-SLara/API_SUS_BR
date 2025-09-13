package com.csi.sus.repositories;

import com.csi.sus.model.vacinaDoenca.VacinaDoenca;
import com.csi.sus.model.vacinaDoenca.VacinaDoencaId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
A convenção de nome do Spring Data JPA é 
findBy + NomeDoCampoDaEntidade
mas para campos dentro de uma chave embutida, se usa
findBy + NomeDoCampoDaChaveEmbutida + _ + NomeDoCampoDentroDaChave.
 */

@Repository
public interface VacinaDoencaRepository extends
        JpaRepository<VacinaDoenca, VacinaDoencaId> {
    
    //busca vacinas de uma doenca especifica
    List<VacinaDoenca> findById_IdDoenca(Long idDoenca);

    //busca doencas para uma vacina especifica
    List<VacinaDoenca> findById_IdVacina(Long idVacina);

}
