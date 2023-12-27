package br.com.voehorizon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class VooDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("data_partida")
    private Date dataHoraPartida;
    @JsonProperty("aeroporto_origem")
    private AeroportoDTO aeroportoOrigem;
    @JsonProperty("aeroporto_destino")
    private AeroportoDTO aeroportoDestino;
    @JsonProperty("classes")
    private List<ClasseVooDTO> classes;

}