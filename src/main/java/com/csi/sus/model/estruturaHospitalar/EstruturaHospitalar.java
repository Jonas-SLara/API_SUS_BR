package com.csi.sus.model.estruturaHospitalar;

import com.csi.sus.model.cidade.Cidade;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

//jpa hibernate
@Entity
@Table(name = "estrutura_hospitalar")

public class EstruturaHospitalar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //usar um enum de strings para validar o tipo de leito
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 50)
    private TipoLeito tipo;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;
}
