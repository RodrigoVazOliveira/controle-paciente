package br.dev.rvz.gerenciadorhopital.services;

import br.dev.rvz.gerenciadorhopital.dto.ConsultaDTO;
import br.dev.rvz.gerenciadorhopital.dto.PacienteDTO;
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

    public Consulta cadastrar(Consulta consulta) {
        consultas.add(consulta);
        return consulta;
    }

    public List<Consulta> pesquisarConsultaPorData(LocalDate dataConsulta) {
        List<Consulta> dados = new ArrayList<>();

        for (Consulta consulta : consultas) {
            if (consulta.getDataConsulta().equals(dataConsulta)) {
                dados.add(consulta);
            }
        }

        if (dados.size() > 0) {
            return dados;
        }

        throw new RuntimeException("Não foi localizado nenhuma consulta com a data " + dataConsulta);
    }

    public void excluirConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

}
