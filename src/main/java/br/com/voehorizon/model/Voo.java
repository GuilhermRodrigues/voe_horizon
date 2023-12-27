package br.com.voehorizon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Voo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataHoraPartida;

    @ManyToOne
    @JoinColumn(name = "aeroporto_origem_id")
    private Aeroporto aeroportoOrigem;

    @ManyToOne
    @JoinColumn(name = "aeroporto_destino_id")
    private Aeroporto aeroportoDestino;

    @OneToMany(mappedBy = "voo", cascade = CascadeType.ALL)
    private List<ClasseVoo> classes;

    public void addClasse(ClasseVoo classeVoo) {
        classes.add(classeVoo);
        classeVoo.setVoo(this);
    }
}