package br.dev.rvz.gerenciadorhopital.dto;

import br.dev.rvz.gerenciadorhopital.models.Paciente;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class PacienteDTO {
    private String nome;

    @Min(value = 18, message = "Apenas maiores de 18 anos")
    private Integer idade;

    @CPF(message = "CPF inválido")
    private String cpf;

    @Email(message = "E-Mail inválido!")
    private String email;

    public PacienteDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        paciente.setEmail(this.email);
        return paciente;
    }
}
