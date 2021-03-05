package br.dev.rvz.gerenciadorhopital.services;

import br.dev.rvz.gerenciadorhopital.models.Historico;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    List<Paciente> pacientes = new ArrayList<>();

    public Paciente cadatrar(Paciente paciente) {
        if (!pacientes.contains(paciente)) {
            pacientes.add(paciente);
            return paciente;
        }
        throw new RuntimeException("O paciente com CPF " + paciente.getCpf() + " Já existe cadastrado");
    }


}
