package br.dev.rvz.gerenciadorhopital.controllers;

import br.dev.rvz.gerenciadorhopital.models.Historico;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import br.dev.rvz.gerenciadorhopital.services.HistoricoService;
import br.dev.rvz.gerenciadorhopital.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/historico/")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("{cpf}/")
    @ResponseStatus(HttpStatus.CREATED)
    public Historico cadastrar(@PathVariable String cpf, @RequestBody Historico historico) {
        try {
            Paciente paciente = pacienteService.pesquisar(cpf);
            return historicoService.cadastrar(paciente.getHistoricos(), historico);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
