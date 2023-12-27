package br.com.voehorizon.service.mapper;

import br.com.voehorizon.dto.AeroportoDTO;
import br.com.voehorizon.model.Aeroporto;
import br.com.voehorizon.repository.aeroporto.response.AeroportoApiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AeroportoMapper {
    @Mappings({
            @Mapping(source = "cod", target = "codigoIATA"),
            @Mapping(target = "idCidade", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    AeroportoDTO toAeroportoDTO(AeroportoApiResponse aeroportoApiResponse);

    @Mappings({
            @Mapping(source = "cidade.id", target = "idCidade"),
    })
    AeroportoDTO toAeroportoDTO(Aeroporto aeroporto);

    List<AeroportoDTO> toAeroportoDTO(List<Aeroporto> aeroporto);

    @Mappings({
            @Mapping(source = "cod", target = "codigoIATA"),
            @Mapping(target = "cidade", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    Aeroporto toAeroporto(AeroportoApiResponse aeroportoApiResponse);

}
