package br.com.deliver.testePratico.controller;

import br.com.deliver.testePratico.model.Contas;
import br.com.deliver.testePratico.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contas")
public class ContasController {

    private final ContasService service;

    @Autowired
    public ContasController(ContasService service) {
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Contas contas) {
        this.service.save(contas);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Contas> list() {
        return this.service.findAll();
    }
}
