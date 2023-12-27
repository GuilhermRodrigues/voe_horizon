package br.com.voehorizon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class EstadoDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("uf")
    private String uf;

}