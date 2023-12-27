package br.com.voehorizon.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Aeroporto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigoIATA;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

}