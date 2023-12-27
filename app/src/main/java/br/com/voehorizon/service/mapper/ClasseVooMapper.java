package br.com.voehorizon.service.mapper;

import br.com.voehorizon.dto.ClasseVooDTO;
import br.com.voehorizon.dto.VooDTO;
import br.com.voehorizon.model.ClasseVoo;
import br.com.voehorizon.model.Voo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ClasseVooMapper {
    @Mappings({
            @Mapping(target = "voo", ignore = true)
    })
    ClasseVoo toClasseVoo(ClasseVooDTO classeVooDTO);
    @Mappings({
            @Mapping(source = "voo.id", target = "idVoo"),
    })
    ClasseVooDTO toclasseVooDTO(ClasseVoo classeVoo);
}
