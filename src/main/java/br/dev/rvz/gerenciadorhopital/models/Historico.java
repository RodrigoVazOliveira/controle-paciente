package br.dev.rvz.gerenciadorhopital.models;

import java.time.LocalDate;

public class Historico implements Comparable<Historico> {
    private LocalDate dataDoRegistro;
    private String notaHistorico;

    public Historico() {
    }

    public LocalDate getDataDoRegistro() {
        return dataDoRegistro;
    }

    public void setDataDoRegistro(LocalDate dataDoRegistro) {
        this.dataDoRegistro = dataDoRegistro;
    }

    public String getNotaHistorico() {
        return notaHistorico;
    }

    public void setNotaHistorico(String notaHistorico) {
        this.notaHistorico = notaHistorico;
    }

    @Override
    public int compareTo(Historico o) {
        return getDataDoRegistro().compareTo(o.getDataDoRegistro());
    }
}
