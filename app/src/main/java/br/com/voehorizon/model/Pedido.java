package br.com.voehorizon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Passageiro comprador;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Passagem> passagens;

    private int quantidadePassagens;

    @ManyToOne
    @JoinColumn(name = "classe_voo_id")
    private ClasseVoo classeEscolhida;

    private boolean despachoBagagem;


}
