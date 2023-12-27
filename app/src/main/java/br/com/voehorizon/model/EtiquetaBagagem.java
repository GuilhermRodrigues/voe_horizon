package br.com.voehorizon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class EtiquetaBagagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroIdentificacaoBagagem;

    @ManyToOne
    @JoinColumn(name = "passagem_id")
    private Passagem passagem;

    // getters e setters
}