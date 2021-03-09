package br.dev.rvz.gerenciadorhopital.exceptions;

public class ObjetoDeErro {
    private String menssagem;
    private String campo;

    public ObjetoDeErro() {
    }

    public ObjetoDeErro(String menssagem, String campo) {
        this.menssagem = menssagem;
        this.campo = campo;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}
