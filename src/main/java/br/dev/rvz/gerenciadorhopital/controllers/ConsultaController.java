package br.dev.rvz.gerenciadorhopital.controllers;

import br.dev.rvz.gerenciadorhopital.dto.ConsultaDTO;
import br.dev.rvz.gerenciadorhopital.models.Consulta;
import br.dev.rvz.gerenciadorhopital.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/consulta/")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PutMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta cadastrar(@RequestBody ConsultaDTO consulta, @RequestParam("cpf") String cpf) {
        try {
            return service.cadastrar(consulta, cpf);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("buscar")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsultaDTO> pesquisarConsultaPorData(
            @RequestParam("data")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate dataDaConsulta) {
        try {
            return service.pesquisarConsultaPorData(dataDaConsulta);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
