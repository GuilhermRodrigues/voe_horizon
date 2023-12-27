package br.com.voehorizon.controller;

import br.com.voehorizon.dto.EstadoDTO;
import br.com.voehorizon.service.EstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/estado")
public class EstadoController {

    private final EstadoService service;

    @PostMapping
    public void gravarEstados(){
        service.gravarEstados();
    }

    @GetMapping
    public List<EstadoDTO> obterEstados(){
        return service.obterEstados();
    }

    @GetMapping("/buscar")
    public EstadoDTO buscarPorUf(@RequestParam String uf){
        return service.buscarEstado(uf);
    }
}