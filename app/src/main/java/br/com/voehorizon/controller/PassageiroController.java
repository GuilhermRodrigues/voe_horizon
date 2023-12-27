package br.com.voehorizon.controller;

import br.com.voehorizon.dto.PassageiroDTO;
import br.com.voehorizon.service.PassageiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passageiro")
public class PassageiroController {

    @Autowired
    private PassageiroService service;


    @GetMapping(value = "/{id_passageiro}")
    public PassageiroDTO retornarAeroporto(@PathVariable("id_passageiro") Long idPassageiro) {
        return service.obterPassageiro(idPassageiro);
    }

    @PostMapping
    public PassageiroDTO criarAeroportos(@RequestBody PassageiroDTO passageiro) {
        return service.gravarPassageiro(passageiro);
    }
}