package br.dev.rvz.gerenciadorhopital.controllers;

import br.dev.rvz.gerenciadorhopital.dto.PacienteDTO;
import br.dev.rvz.gerenciadorhopital.models.Historico;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import br.dev.rvz.gerenciadorhopital.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paciente/")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrarPaciente(@RequestBody @Valid PacienteDTO pacienteDTO) {
        return pacienteService.cadatrar(pacienteDTO.converterPacienteDTOParaPaciente());
    }

    @GetMapping("{cpf}/")
    @ResponseStatus(HttpStatus.OK)
    public Paciente pesquisarPaciente(@PathVariable String cpf) {
        return pacienteService.pesquisar(cpf);
    }
}
