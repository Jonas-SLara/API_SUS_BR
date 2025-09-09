package com.csi.sus.model.estruturaHospitalar;
import java.util.UUID;

import com.csi.sus.model.cidade.Cidade;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
//lombok
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

//jpa hibernate orm
@Entity
@Table(name = "estrutura_hospitalar")

public class EstruturaHospitalar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;
}
