package br.dev.rvz.gerenciadorhopital.controllers;

import br.dev.rvz.gerenciadorhopital.dto.ConsultaDTO;
import br.dev.rvz.gerenciadorhopital.dto.PacienteDTO;
import br.dev.rvz.gerenciadorhopital.models.Consulta;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import br.dev.rvz.gerenciadorhopital.services.ConsultaService;
import br.dev.rvz.gerenciadorhopital.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consulta/")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @Autowired
    private PacienteService pacienteService;

    @PutMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta cadastrar(@RequestBody ConsultaDTO consultaDTO, @RequestParam("cpf") String cpf) {
        try {
            Paciente paciente = pacienteService.pesquisar(cpf);
            Consulta consulta = consultaDTO.converterConsultaDTOParaConsulta(paciente);
            return service.cadastrar(consulta);
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
            List<Consulta> dados = service.pesquisarConsultaPorData(dataDaConsulta);
            List<ConsultaDTO> consultaDTOS = new ArrayList<>();
            for (Consulta consulta : dados) {
                consultaDTOS.add(new ConsultaDTO().converterConsultaParaConsultaDTO(consulta));
            }
            return consultaDTOS;
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
