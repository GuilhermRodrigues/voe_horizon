package br.com.voehorizon.controller;

import br.com.voehorizon.dto.ClasseVooDTO;
import br.com.voehorizon.service.ClasseVooService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classe-voo")
public class ClasseVooController {

    private final ClasseVooService service;

    @GetMapping(value = "/{id_classeVoo}")
    public ClasseVooDTO retornarClasseVoo(@PathVariable("id_classeVoo") Long idClasseVoo) {
        return service.obterClasseVoo(idClasseVoo);
    }

    @PostMapping
    public ClasseVooDTO criarClasseVoo(@RequestBody ClasseVooDTO classeVooDTO) {
        return service.gravarClasseVoo(classeVooDTO);
    }
}