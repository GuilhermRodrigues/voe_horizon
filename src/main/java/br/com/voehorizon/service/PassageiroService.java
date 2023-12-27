package br.com.voehorizon.service;

import br.com.voehorizon.dto.PassageiroDTO;
import br.com.voehorizon.exception.BusinessException;
import br.com.voehorizon.model.Passageiro;
import br.com.voehorizon.repository.PassageiroRepository;
import br.com.voehorizon.service.mapper.PassageiroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassageiroService {

    private final PassageiroRepository repository;
    private final PassageiroMapper mapper;

    @Autowired
    public PassageiroService(PassageiroRepository repository, PassageiroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PassageiroDTO gravarPassageiro(PassageiroDTO passageiroDTO){
        Passageiro passageiro = mapper.toPassageiro(passageiroDTO);
        return mapper.toPassageiroDTO(repository.save(passageiro));
    }

    public PassageiroDTO obterPassageiro(Long id){
        return mapper.toPassageiroDTO( repository.findById(id).orElseThrow(()-> new BusinessException("Voo não encontrado")));
    }

}
