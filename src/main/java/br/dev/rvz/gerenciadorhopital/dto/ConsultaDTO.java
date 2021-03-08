package br.dev.rvz.gerenciadorhopital.dto;

import br.dev.rvz.gerenciadorhopital.models.TipoConsulta;

import java.time.LocalDate;

public class ConsultaDTO {
    private LocalDate dataConsulta;
    private TipoConsulta tipoConsulta;

    public ConsultaDTO() {
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
