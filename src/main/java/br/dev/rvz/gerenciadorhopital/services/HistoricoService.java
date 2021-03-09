package br.dev.rvz.gerenciadorhopital.services;

import br.dev.rvz.gerenciadorhopital.models.Historico;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HistoricoService {

    public Historico cadastrar(List<Historico> historicos, Historico historico) {
        historicos.add(historico);
        Collections.sort(historicos);
        return historico;
    }

}