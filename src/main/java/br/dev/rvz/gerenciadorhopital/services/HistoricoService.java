package br.dev.rvz.gerenciadorhopital.services;

import br.dev.rvz.gerenciadorhopital.models.Historico;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class HistoricoService {

    public Historico cadastrar(Paciente paciente, Historico historico) {
        paciente.getHistoricos().add(historico);
        Collections.sort(paciente.getHistoricos());
        return historico;
    }

}