package br.com.voehorizon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Passageiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Date dataNascimento;
    @OneToMany(mappedBy = "passageiro", cascade = CascadeType.ALL)
    private List<Passagem> passagens;
}