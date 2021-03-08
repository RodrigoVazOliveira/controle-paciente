package br.dev.rvz.gerenciadorhopital.dto;

import br.dev.rvz.gerenciadorhopital.models.Consulta;
import br.dev.rvz.gerenciadorhopital.models.Paciente;
import br.dev.rvz.gerenciadorhopital.models.TipoConsulta;

import java.time.LocalDate;

public class ConsultaDTO {
    private LocalDate dataConsulta;
    private TipoConsulta tipoConsulta;
    private PacienteDTO pacienteDTO;

    public ConsultaDTO() {
    }

    public PacienteDTO getPacienteDTO() {
        return pacienteDTO;
    }

    public void setPacienteDTO(PacienteDTO pacienteDTO) {
        this.pacienteDTO = pacienteDTO;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public ConsultaDTO converterConsultaParaConsultaDTO(Consulta consulta) {
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

    public Consulta converterConsultaDTOParaConsulta(Paciente paciente) {
        Consulta consulta = new Consulta();
        consulta.setDataConsulta(this.dataConsulta);
        consulta.setTipoConsulta(this.tipoConsulta);
        consulta.setPaciente(paciente);
        return consulta;
    }

}
