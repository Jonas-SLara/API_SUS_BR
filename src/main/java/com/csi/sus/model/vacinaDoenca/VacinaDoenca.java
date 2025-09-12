package com.csi.sus.model.vacinaDoenca;

import com.csi.sus.model.doenca.Doenca;
import com.csi.sus.model.vacina.Vacina;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//lombok
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

//jpa
@Entity
@Table(name = "vacina_doenca")
public class VacinaDoenca {
    @EmbeddedId
    private VacinaDoencaId id;
    
    //uso de MapsId para relacionar a chave estranjeira da chave composta
    @ManyToOne
    @MapsId("idDoenca")
    @JoinColumn(name = "id_doenca")
    private Doenca doenca;
    
    @ManyToOne
    @MapsId("idVacina")
    @JoinColumn(name = "id_vacina")
    private Vacina vacina;
}
