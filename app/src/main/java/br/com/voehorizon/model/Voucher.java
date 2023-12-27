package br.com.voehorizon.model;

import javax.persistence.*;
@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroVoucher;

    @ManyToOne
    @JoinColumn(name = "passagem_id")
    private Passagem passagem;

}