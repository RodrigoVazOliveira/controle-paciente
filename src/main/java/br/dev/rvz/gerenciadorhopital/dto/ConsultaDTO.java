package br.dev.rvz.gerenciadorhopital.dto;

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
}
