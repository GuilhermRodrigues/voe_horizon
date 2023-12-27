package br.com.voehorizon.controller;

import br.com.voehorizon.dto.VooDTO;
import br.com.voehorizon.service.VooService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voo")
public class VooController {

    private final VooService service;

    @GetMapping(value = "/{id_voo}")
    public VooDTO retornarVoo(@PathVariable("id_voo") Long idVoo){
        return service.obterVoo(idVoo);
    }

    @PostMapping
    public VooDTO criarVoo(@RequestBody VooDTO vooDTO){
        return service.gravarVoo(vooDTO);
    }
}