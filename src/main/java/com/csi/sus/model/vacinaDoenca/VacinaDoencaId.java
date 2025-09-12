package com.csi.sus.model.vacinaDoenca;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode //gera equals e hash code baseado nos campos

// diz ao jpa que esta classe pode ser embutida em outra entidade 
@Embeddable
public class VacinaDoencaId implements Serializable{
    @Column(name = "id_doenca")
    private Long idDoenca;
    
    @Column(name = "id_vacina")
    private Long idVacina;
}
