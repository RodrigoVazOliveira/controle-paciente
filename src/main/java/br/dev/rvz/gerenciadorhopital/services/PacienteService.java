package br.dev.rvz.gerenciadorhopital.services;

import br.dev.rvz.gerenciadorhopital.models.Historico;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PacienteService {

    List<Paciente> pacientes = new ArrayList<>();

    @Autowired
    private HistoricoService historicoService;

    public Paciente cadatrar(Paciente paciente) throws RuntimeException {
        if (!pacientes.contains(paciente)) {
            paciente.setHistoricos(new ArrayList<>());
            pacientes.add(paciente);
            return paciente;
        }
        throw new RuntimeException("O paciente com CPF " + paciente.getCpf() + " Já existe cadastrado");
    }

    public Paciente cadastrarHistorico(String cpf, Historico historico) throws RuntimeException {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equalsIgnoreCase(cpf)) {
                historicoService.cadastrar(paciente, historico);
                return paciente;
            }
        }
        throw new RuntimeException("Paciente com CPF " + cpf + " não foi localizado");
    }

    public Paciente pesquisar(String cpf) throws RuntimeException {
        Paciente paciente = new Paciente();
        paciente.setCpf(cpf);
        return pesquisar(paciente);
    }

    public Paciente pesquisar(Paciente paciente) throws RuntimeException {
        for(Paciente p : pacientes) {
            if (p.getCpf().equalsIgnoreCase(paciente.getCpf())) {
                return p;
            }
        }
        throw new RuntimeException("O paciente com CPF " + paciente.getCpf() + " Já existe cadastrado");
    }
}
