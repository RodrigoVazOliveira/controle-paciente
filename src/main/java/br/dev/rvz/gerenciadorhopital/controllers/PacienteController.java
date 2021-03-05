package br.dev.rvz.gerenciadorhopital.controllers;

import br.dev.rvz.gerenciadorhopital.models.Historico;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import br.dev.rvz.gerenciadorhopital.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/paciente/")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrarPaciente(@RequestBody Paciente paciente) {
        try {
            pacienteService.cadatrar(paciente);
            return paciente;
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("historico")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrarHistorico(@RequestParam("cpf") String cpf,  @RequestBody Historico historico) {
        try {
            return pacienteService.cadastrarHistorico(cpf, historico);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{cpf}/")
    @ResponseStatus(HttpStatus.OK)
    public Paciente pesquisarPaciente(@PathVariable String cpf) {
        try {
            return pacienteService.pesquisar(cpf);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
