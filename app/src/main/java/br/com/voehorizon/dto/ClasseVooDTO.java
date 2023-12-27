package br.com.voehorizon.dto;


import br.com.voehorizon.enumeration.TipoClasseVooEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClasseVooDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("tipo")
    private TipoClasseVooEnum tipo;
    @JsonProperty("quantidade_assentos")
    private int quantidadeAssentos;
    @JsonProperty("valor_assento")
    private double valorAssento;
    @JsonProperty("id_voo")
    private Long idVoo;

}