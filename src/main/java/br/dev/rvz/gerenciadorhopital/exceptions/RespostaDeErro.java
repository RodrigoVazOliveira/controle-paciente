package br.dev.rvz.gerenciadorhopital.exceptions;

import java.util.List;

public class RespostaDeErro {
    private String tipoDeErro;
    private int codigoDoErro;
    private String statusCode;
    private List<ObjetoDeErro> objetoDeErro;

    public RespostaDeErro() {
    }

    public RespostaDeErro(String tipoDeErro, int codigoDoErro, String statusCode, List<ObjetoDeErro> objetoDeErro) {
        this.tipoDeErro = tipoDeErro;
        this.codigoDoErro = codigoDoErro;
        this.statusCode = statusCode;
        this.objetoDeErro = objetoDeErro;
    }

    public String getTipoDeErro() {
        return tipoDeErro;
    }

    public void setTipoDeErro(String tipoDeErro) {
        this.tipoDeErro = tipoDeErro;
    }

    public int getCodigoDoErro() {
        return codigoDoErro;
    }

    public void setCodigoDoErro(int codigoDoErro) {
        this.codigoDoErro = codigoDoErro;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<ObjetoDeErro> getObjetoDeErro() {
        return objetoDeErro;
    }

    public void setObjetoDeErro(List<ObjetoDeErro> objetoDeErro) {
        this.objetoDeErro = objetoDeErro;
    }
}
