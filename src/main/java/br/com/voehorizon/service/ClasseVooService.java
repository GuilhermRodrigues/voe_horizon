package br.com.voehorizon.service;

import br.com.voehorizon.dto.ClasseVooDTO;
import br.com.voehorizon.dto.VooDTO;
import br.com.voehorizon.enumeration.TipoClasseVooEnum;
import br.com.voehorizon.exception.BusinessException;
import br.com.voehorizon.model.ClasseVoo;
import br.com.voehorizon.model.Voo;
import br.com.voehorizon.repository.ClasseVooRepository;
import br.com.voehorizon.repository.VooRepository;
import br.com.voehorizon.service.mapper.ClasseVooMapper;
import br.com.voehorizon.service.mapper.VooMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClasseVooService {

    private final ClasseVooRepository repository;
    private final ClasseVooMapper mapper;
    private final VooService vooService;

    @Autowired
    public ClasseVooService(ClasseVooRepository repository, ClasseVooMapper mapper, VooService vooService) {
        this.repository = repository;
        this.mapper = mapper;
        this.vooService = vooService;
    }

    public ClasseVooDTO gravarClasseVoo(ClasseVooDTO classeVooDTO) {
        VooDTO vooDTO = vooService.obterVoo(classeVooDTO.getIdVoo());
        if (contemTipoClasse(vooDTO.getClasses(), classeVooDTO)) {
            throw new BusinessException("Esse Voo já tem uma classe desse tipo");
        }

        Voo voo = new Voo();
        voo.setId(vooDTO.getId());

        ClasseVoo classeVoo = mapper.toClasseVoo(classeVooDTO);
        classeVoo.setVoo(voo);
        return mapper.toclasseVooDTO(repository.save(classeVoo));
    }

    public List<ClasseVooDTO> gravarClasseVooList(List<ClasseVooDTO> classeVooDTO) {
        return classeVooDTO.stream().map(this::gravarClasseVoo).collect(Collectors.toList());
    }


    public ClasseVooDTO obterClasseVoo(Long id) {
        return mapper.toclasseVooDTO(repository.findById(id).orElseThrow(() -> new BusinessException("Voo não encontrado")));
    }

    public boolean contemTipoClasse(List<ClasseVooDTO> classeVoos, ClasseVooDTO classeVooDTO) {
        Optional<ClasseVooDTO> classeVoosResult = classeVoos.stream().filter(classeVoo -> Objects.equals(classeVooDTO.getTipo(), classeVoo.getTipo())).findFirst();
        return classeVoosResult.isEmpty();
    }

}
