package br.com.voehorizon.service;

import br.com.voehorizon.dto.PassagemDTO;
import br.com.voehorizon.exception.BusinessException;
import br.com.voehorizon.model.Passagem;
import br.com.voehorizon.repository.PassagemRepository;
import br.com.voehorizon.service.mapper.PassagemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassagemService {

    private final PassagemRepository repository;
    private final PassagemMapper mapper;

    @Autowired
    public PassagemService(PassagemRepository repository, PassagemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PassagemDTO gravarPassam(PassagemDTO passagemDTO){
        Passagem passagem = mapper.toPassagem(passagemDTO);

        return mapper.toPassagemDTO(repository.save(passagem));
    }

    public PassagemDTO obterPassagem(Long id){
        return mapper.toPassagemDTO(repository.findById(id).orElseThrow(()-> new BusinessException("Voo não encontrado")));
    }

}
