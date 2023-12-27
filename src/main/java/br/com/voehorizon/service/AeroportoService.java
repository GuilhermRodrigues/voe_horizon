package br.com.voehorizon.service;

import br.com.voehorizon.dto.AeroportoDTO;
import br.com.voehorizon.exception.BusinessException;
import br.com.voehorizon.model.Aeroporto;
import br.com.voehorizon.model.Cidade;
import br.com.voehorizon.model.Estado;
import br.com.voehorizon.repository.AeroportoRepository;
import br.com.voehorizon.repository.CidadeRepository;
import br.com.voehorizon.repository.EstadoRepository;
import br.com.voehorizon.repository.aeroporto.AeroportoApiRepository;
import br.com.voehorizon.repository.aeroporto.response.AeroportoApiResponse;
import br.com.voehorizon.service.mapper.AeroportoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeroportoService {

    private final AeroportoApiRepository aeroportoApiRepository;
    private final AeroportoMapper aeroportoMapper;
    private final EstadoRepository estadoRepository;
    private final CidadeRepository cidadeRepository;
    private final AeroportoRepository aeroportoRepository;

    @Autowired
    public AeroportoService(AeroportoApiRepository aeroportoApiRepository, AeroportoMapper aeroportoMapper, EstadoRepository estadoRepository, CidadeRepository cidadeRepository, AeroportoRepository aeroportoRepository) {
        this.aeroportoApiRepository = aeroportoApiRepository;
        this.aeroportoRepository = aeroportoRepository;
        this.aeroportoMapper = aeroportoMapper;
        this.estadoRepository = estadoRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public void gravarAeroportos() {
        List<AeroportoApiResponse> apiResponseList = aeroportoApiRepository.obterAeroportos();
        apiResponseList.stream().forEach(aeroportoApiResponse -> {
            Cidade cidade = new Cidade();
            String uf = extractAfterSeparator(aeroportoApiResponse.getNomeCidade());
            if (!uf.isEmpty()) {
                Estado estado = estadoRepository.findByUf(uf);
                cidade.setEstado(estado);
            }

            cidade.setNome(aeroportoApiResponse.getNomeCidade());
            cidadeRepository.save(cidade);

            Aeroporto aeroporto = aeroportoMapper.toAeroporto(aeroportoApiResponse);
            aeroporto.setCidade(cidade);
            aeroportoRepository.save(aeroporto);
        });
    }

    public Page<AeroportoDTO> obterAeroportos(Pageable pageable) {
        Page<Aeroporto> aeroportos = aeroportoRepository.findAll(pageable);
        List<AeroportoDTO> response = aeroportoMapper.toAeroportoDTO(aeroportos.getContent());
        return new PageImpl<>(response, pageable, aeroportos.getTotalElements());
    }

    public AeroportoDTO obterAeroporto(Long id) {
        return aeroportoMapper.toAeroportoDTO(aeroportoRepository.findById(id).orElseThrow(() -> new BusinessException("Aeroporto não encontrado")));

    }

    private static String extractAfterSeparator(String input) {
        String[] parts = input.split("[-/]");
        if (parts.length > 1) {
            return parts[parts.length - 1];
        }
        return "";
    }
}
