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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

//jpa hibernate
@Entity
@Table(name = "cidade")

public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Min(0)
    @Column(name = "populacao", nullable = false)
    private int populacao;

    @Size(min = 2, max = 2, 
        message = "UF deve ter exatamente 2 char")
    @Column(name = "estado", length = 2, nullable = false)
    private String estado;

    @Size(min = 7, max = 7, 
        message = "codigo ibge deve ter exatamente 7char")
    @Column(name = "codigo_ibge", length = 7,
        unique = true, nullable = false)
    private String codigoIbge;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    List<EstruturaHospitalar> estruturaHospitalares;
}