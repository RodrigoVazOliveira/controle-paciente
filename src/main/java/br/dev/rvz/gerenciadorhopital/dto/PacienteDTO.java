package br.dev.rvz.gerenciadorhopital.dto;

import br.dev.rvz.gerenciadorhopital.models.Paciente;

public class PacienteDTO {
    private String nome;
    private Integer idade;
    private String cpf;

    public PacienteDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Paciente converterPacienteDTOParaPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNome(this.nome);
        paciente.setCpf(this.cpf);
        paciente.setIdade(this.idade);

        return paciente;
    }
}
