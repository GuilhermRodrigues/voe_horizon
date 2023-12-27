package br.com.voehorizon.repository.aeroporto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AeroportoApiResponse {

    private String nome;
    private String cod;
    @JsonProperty("cidade")
    private String nomeCidade;

}
