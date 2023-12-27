package br.com.voehorizon.service.mapper;

import br.com.voehorizon.dto.VooDTO;
import br.com.voehorizon.model.Voo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses = {AeroportoMapper.class, ClasseVooMapper.class})
public interface VooMapper {
    Voo toVoo(VooDTO vooDTO);
    VooDTO toVooDTO(Voo voo);
}
