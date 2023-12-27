package br.com.voehorizon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassagemDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("preco_total")
    private double precoTotal;
    @JsonProperty("despacho_bagagem")
    private boolean despachoBagagem;
    @JsonProperty("passageiro")
    private PassageiroDTO passageiro;
    @JsonProperty("classe_voo")
    private ClasseVooDTO classeVoo;

}