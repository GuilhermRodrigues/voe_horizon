package br.com.voehorizon.service.mapper;

import br.com.voehorizon.dto.PassageiroDTO;
import br.com.voehorizon.dto.VooDTO;
import br.com.voehorizon.model.Passageiro;
import br.com.voehorizon.model.Voo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassageiroMapper {
    Passageiro toPassageiro(PassageiroDTO vooDTO);
    PassageiroDTO toPassageiroDTO(Passageiro voo);
}
