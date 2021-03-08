package br.dev.rvz.gerenciadorhopital.services;

import br.dev.rvz.gerenciadorhopital.models.Consulta;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private PacienteService pacienteService;

    List<Consulta> consultas = new ArrayList<>();

    public void cadastrar(Consulta consulta, String cpf) {
        Paciente paciente = pacienteService.pesquisar(cpf);
        consultas.add(consulta);
    }

    public List<Consulta> pesquisarConsultaPorData(LocalDate dataConsulta) {
        List<Consulta> dados = new ArrayList<>();

        for (Consulta consulta : consultas) {
            if (consulta.equals(dataConsulta)) {
                dados.add(consulta);
            }
        }

        return dados;
    }

    public Consulta excluirConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

}
