package br.com.voehorizon.dto;

import br.com.voehorizon.model.Passagem;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {
    private Long id;
    private Date dataCompra;
    private int quantidadePassagens;
    private List<Passagem> passagens;

}
