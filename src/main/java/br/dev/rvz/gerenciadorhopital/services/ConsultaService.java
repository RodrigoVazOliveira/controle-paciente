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

    public Consulta cadastrar(ConsultaDTO consultaDTO, String cpf) {
        Paciente paciente = pacienteService.pesquisar(cpf);

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setDataConsulta(consultaDTO.getDataConsulta());
        consulta.setTipoConsulta(consultaDTO.getTipoConsulta());

        consultas.add(consulta);

        return consulta;
    }

    public List<Consulta> pesquisarConsultaPorData(LocalDate dataConsulta) {
        List<Consulta> dados = new ArrayList<>();

        for (Consulta consulta : consultas) {
            if (consulta.equals(dataConsulta)) {
                dados.add(consulta);
            }
        }

        if (!dados.isEmpty()) {
            return dados;
        }

        throw new RuntimeException("Não foi localizado nenhuma consulta com a data " + dataConsulta);
    }

    private ConsultaDTO converterConsultaParaConsultaDTO(Consulta consulta) {
        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setDataConsulta(consulta.getDataConsulta());
        consultaDTO.setTipoConsulta(consulta.getTipoConsulta());

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome(consulta.getPaciente().getNome());
        pacienteDTO.setCpf(consulta.getPaciente().getCpf());
        pacienteDTO.setIdade(consulta.getPaciente().getIdade());

        consultaDTO.setPacienteDTO(pacienteDTO);

        return consultaDTO;
    }

    public void excluirConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

}
