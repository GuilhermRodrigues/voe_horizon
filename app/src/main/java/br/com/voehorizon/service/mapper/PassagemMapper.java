package br.com.voehorizon.service.mapper;

import br.com.voehorizon.dto.PassagemDTO;
import br.com.voehorizon.model.Passagem;
import br.com.voehorizon.model.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ClasseVooMapper.class})
public interface PassagemMapper {
    Passagem toPassagem(PassagemDTO passagemDTO);
    PassagemDTO toPassagemDTO(Passagem passagem);
}
