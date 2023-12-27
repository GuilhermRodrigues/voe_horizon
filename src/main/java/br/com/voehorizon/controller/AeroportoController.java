package br.com.voehorizon.controller;

import br.com.voehorizon.dto.AeroportoDTO;
import br.com.voehorizon.service.AeroportoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aeroporto")
public class AeroportoController {

    @Autowired
    private AeroportoService aeroportoService;

    @GetMapping
    public Page<AeroportoDTO> retornarAeroportos(Pageable pageable) {
        return aeroportoService.obterAeroportos(pageable);
    }

    @GetMapping(value = "/{id_aeroporto}")
    public AeroportoDTO retornarAeroporto(@PathVariable("id_aeroporto") Long idAeroporto) {
        return aeroportoService.obterAeroporto(idAeroporto);
    }

    @PostMapping
    public void criarAeroportos() {
        aeroportoService.gravarAeroportos();
    }
}