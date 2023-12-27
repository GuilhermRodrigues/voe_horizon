package br.com.voehorizon.controller;

import br.com.voehorizon.dto.PassagemDTO;
import br.com.voehorizon.service.PassagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passagem")
public class PassagemController {

    @Autowired
    private PassagemService service;


    @GetMapping(value = "/{id_passagem}")
    public PassagemDTO retornarPassagem(@PathVariable("id_passagem") Long idPassageiro) {
        return service.obterPassagem(idPassageiro);
    }

    @PostMapping
    public PassagemDTO criarPassagem(@RequestBody PassagemDTO passagem) {
        return service.gravarPassam(passagem);
    }
}