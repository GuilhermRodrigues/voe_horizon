package br.com.voehorizon.model;


import br.com.voehorizon.enumeration.TipoClasseVooEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ClasseVoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoClasseVooEnum tipo;
    private int quantideAssentos;
    private double valorAssento;

    @ManyToOne
    @JoinColumn(name = "voo_id")
    private Voo voo;

}