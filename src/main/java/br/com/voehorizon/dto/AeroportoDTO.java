package br.com.voehorizon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AeroportoDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("codigoIATA")
    private String codigoIATA;
    @JsonProperty("id_cidade")
    private Long idCidade;

}
