package com.csi.sus.model.cobertura;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.csi.sus.model.cidade.Cidade;
import com.csi.sus.model.faixaEtaria.FaixaEtaria;
import com.csi.sus.model.vacina.Vacina;

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

//lombok
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

//jpa entidade para o histórico de coberturas
@Entity
@Table(
    name = "cobertura",
    uniqueConstraints = @UniqueConstraint(
        name = "unique_cobertura",
        columnNames = {
            "id_cidade", "id_vacina",
            "id_faixa_etaria", "data_pesquisa"
        }
    )
)
public class Cobertura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //histórico de coberturas se associa a n cidades
    @ManyToOne
    @JoinColumn(name = "id_vacina", nullable = false)
    private Vacina vacina;

    //histórico de coberturas se associa a n cidades
    @ManyToOne
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "id_faixa_etaria", nullable = false)
    private FaixaEtaria faixaEtaria;

    @Column(name = "data_pesquisa", nullable = false)
    //mapeia para o tipo Date no postgres dd/mm/aaaa
    private LocalDate dataPesquisa;

    @Column(name = "populacao_alvo", nullable = false)
    private int populacaoAlvo;

    @Column(name = "vacinados", nullable = false)
    private int vacinados;

    @Column(name = "porcentagem_cobertura",
        precision = 5, scale = 3, nullable = false)
    private BigDecimal porcentagemCobertura;

}
