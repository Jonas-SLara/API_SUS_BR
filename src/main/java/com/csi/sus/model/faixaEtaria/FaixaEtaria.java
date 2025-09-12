package com.csi.sus.model.faixaEtaria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//lombok
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

//jpa
@Entity
@Table(name="faixa_etaria")
public class FaixaEtaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idade_min", nullable = false)
    private int idadeMinima;

    @Column(name = "idade_max", nullable = false)
    private int idadeMaxima;

    @Column(name = "descricao", length = 50)
    private String descricao;
}
