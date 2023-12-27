package br.com.voehorizon.repository.estado.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoIBGEResponse {
    private String nome;
    private String sigla;
}
