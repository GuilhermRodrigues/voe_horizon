package br.com.voehorizon.service;

import br.com.voehorizon.dto.ClasseVooDTO;
import br.com.voehorizon.dto.VooDTO;
import br.com.voehorizon.enumeration.TipoClasseVooEnum;
import br.com.voehorizon.exception.BusinessException;
import br.com.voehorizon.model.Voo;
import br.com.voehorizon.repository.VooRepository;
import br.com.voehorizon.service.mapper.VooMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VooService {

    private final VooRepository vooRepository;
    private final VooMapper vooMapper;

    @Autowired
    public VooService(VooRepository vooRepository, VooMapper vooMapper) {
        this.vooRepository = vooRepository;
        this.vooMapper = vooMapper;
    }

    public VooDTO gravarVoo(VooDTO vooDTO){
        if(Objects.equals(vooDTO.getAeroportoOrigem().getId(), vooDTO.getAeroportoDestino().getId())){
            throw new BusinessException("O Destino e a Origem do Voo precisam ser diferentes");
        }
        if(Objects.equals(vooDTO.getAeroportoOrigem().getIdCidade(), vooDTO.getAeroportoDestino().getIdCidade())){
            throw new BusinessException("A Cidade de Destino deve ser difrente da Origem");
        }
        if(vooDTO.getClasses().isEmpty()){
            throw new BusinessException("O Voo deve possuir pelo menos uma classe");
        }
        if(possuiDoisItensDoMesmoTipo(vooDTO.getClasses())){
            throw new BusinessException("O Voo deve ter classes diferentes");
        }

        Voo vooResponse =  vooRepository.save(vooMapper.toVoo(vooDTO));
        vooResponse.getClasses().stream().forEach(classeVoo -> {
            classeVoo.setVoo(vooResponse);
        });

        return vooMapper.toVooDTO( vooRepository.save(vooResponse));
    }
    public VooDTO obterVoo(Long id){
        return vooMapper.toVooDTO(vooRepository.findById(id).orElseThrow(()-> new BusinessException("Voo não encontrado")));
    }
    public Integer obterQuantidadeDeAcentosPorClasses(List<ClasseVooDTO> classeVoos){
        return classeVoos.stream()
                .mapToInt(ClasseVooDTO::getQuantidadeAssentos)
                .sum();
    }
    public boolean possuiDoisItensDoMesmoTipo(List<ClasseVooDTO> classeVooDTOS) {
        Map<TipoClasseVooEnum, List<ClasseVooDTO>> gruposPorTipo = classeVooDTOS.stream()
                .collect(Collectors.groupingBy(ClasseVooDTO::getTipo));

        return gruposPorTipo.values().stream().anyMatch(grupo -> grupo.size() >= 2);
    }

}
