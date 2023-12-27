package br.com.voehorizon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Passagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double precoTotal;
    private boolean despachoBagagem;

    @ManyToOne
    @JoinColumn(name = "passageiro_id")
    private Passageiro passageiro;

    @ManyToOne
    @JoinColumn(name = "classe_voo_id")
    private ClasseVoo classeVoo;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}