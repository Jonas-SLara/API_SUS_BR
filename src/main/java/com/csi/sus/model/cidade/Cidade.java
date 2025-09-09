package com.csi.sus.model.cidade;

import java.util.List;

import com.csi.sus.model.estruturaHospitalar.EstruturaHospitalar;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

//lombok
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

//jpa hibernate
@Entity
@Table(name = "cidade")

public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "populacao", nullable = false)
    private int populacao;

    @Column(name = "estado", length = 2, nullable = false)
    private String estado;

    @Column(name = "codigo_ibge", length = 7,
        unique = true, nullable = false)
    private String codigoIbge;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    List<EstruturaHospitalar> estruturaHospitalares;
}