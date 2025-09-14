package com.csi.sus.model.epidemia;

import java.time.LocalDate;

import com.csi.sus.model.cidade.Cidade;
import com.csi.sus.model.doenca.Doenca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")//evita loop em relacionamentos
@NoArgsConstructor
@AllArgsConstructor

//jpa
@Entity
@Table(
    name = "epidemia",
    //não pode haver datas de pesquisas iguais em uma mesma cidade
    uniqueConstraints = @UniqueConstraint(
        name="data_unica_por_cidade",
        columnNames = {"id_cidade", "id_doenca", "data_pesquisa"}
    )
)

public class Epidemia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //um historico de epidemias pode estar associada a varias doencas
    @ManyToOne
    @JoinColumn(name = "id_doenca", nullable = false)
    private Doenca doenca;
    
    //um histórico de epidemias pode estar associada a varias cidades
    @ManyToOne
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade cidade;

    private int obitos;

    private int casos;

    @Column(name = "data_pesquisa", nullable=false)
    //mapeia para o formato date dd/mm/aaaa
    private LocalDate dataPesquisa;
}
