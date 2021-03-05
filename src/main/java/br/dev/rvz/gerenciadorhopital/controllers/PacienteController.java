package br.dev.rvz.gerenciadorhopital.controllers;

import br.dev.rvz.gerenciadorhopital.models.Paciente;
import br.dev.rvz.gerenciadorhopital.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/paciente/")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrarPaciente(Paciente paciente) {
        try {
            pacienteService.cadatrar(paciente);
            return paciente;
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
