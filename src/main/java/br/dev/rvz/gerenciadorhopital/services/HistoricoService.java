package br.dev.rvz.gerenciadorhopital.services;

import br.dev.rvz.gerenciadorhopital.models.Historico;
import br.dev.rvz.gerenciadorhopital.models.Paciente;

public class HistoricoService {

    public Historico cadastrar(Paciente paciente, Historico historico) {
        paciente.getHistoricos().add(historico);
        return historico;
    }

}
