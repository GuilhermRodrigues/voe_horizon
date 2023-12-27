package br.com.voehorizon.service;

import br.com.voehorizon.dto.EstadoDTO;
import br.com.voehorizon.model.Estado;
import br.com.voehorizon.repository.EstadoRepository;
import br.com.voehorizon.repository.estado.EstadoApiRepository;
import br.com.voehorizon.repository.estado.response.EstadoIBGEResponse;
import br.com.voehorizon.service.mapper.EstadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    private final EstadoApiRepository estadoApiRepository;
    private final EstadoMapper estadoMapper;
    private final EstadoRepository repository;

    @Autowired
    public EstadoService(EstadoApiRepository estadoApiRepository, EstadoMapper estadoMapper, EstadoRepository repository) {
        this.estadoApiRepository = estadoApiRepository;
        this.estadoMapper = estadoMapper;
        this.repository = repository;
    }

    public void gravarEstados() {
        List<EstadoIBGEResponse> estadoIBGEResponses = estadoApiRepository.obterEstados();
        estadoIBGEResponses.stream().forEach(estadoIBGEResponse -> {
            Estado estado = estadoMapper.toEstado(estadoIBGEResponse);
            repository.save(estado);
        });
    }

    public List<EstadoDTO> obterEstados() {
        return estadoMapper.toListEstadoDTO(repository.findAll());
    }

    public EstadoDTO buscarEstado(String uf) {
        return estadoMapper.toEstadoDTO(repository.findByUf(uf));
    }

}
