package br.com.voehorizon.service.mapper;

import br.com.voehorizon.dto.EstadoDTO;
import br.com.voehorizon.model.Estado;
import br.com.voehorizon.repository.aeroporto.response.AeroportoApiResponse;
import br.com.voehorizon.repository.estado.response.EstadoIBGEResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoMapper {
    @Mappings({
            @Mapping(source = "sigla", target = "uf"),
            @Mapping(target = "id", ignore = true)
    })
    Estado toEstado(EstadoIBGEResponse estadoIBGEResponse);

    EstadoDTO toEstadoDTO(Estado estado);

    List<EstadoDTO> toListEstadoDTO(List<Estado> estados);

}
