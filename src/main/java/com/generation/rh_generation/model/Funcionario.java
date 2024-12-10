package com.generation.rh_generation.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 3, max = 150)
    private String nome;

    @NotBlank
    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @NotBlank
    @Size(min = 11, max = 11)
    private String telefone;

    @NotBlank
    @Email
    private String email;

    @ManyToOne
    @JsonIgnoreProperties("funcionario")
    private Cargo cargo;


    public long getId() {
        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public @NotBlank @Size(min = 3, max = 150) String getNome() {

        return nome;
    }

    public void setNome(@NotBlank @Size(min = 3, max = 150) String nome) {

        this.nome = nome;
    }

    public @NotBlank @CPF String getCpf() {

        return cpf;
    }

    public void setCpf(@NotBlank @CPF String cpf) {

        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {

        return dataNascimento;
    }

    public void setDataNascimento( LocalDate dataNascimento) {

        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao( LocalDate dataAdmissao) {

        this.dataAdmissao = dataAdmissao;
    }

    public @NotBlank @Size(min = 11, max = 11) String getTelefone() {

        return telefone;
    }

    public void setTelefone(@NotBlank @Size(min = 11, max = 11) String telefone) {

        this.telefone = telefone;
    }

    public @NotBlank @Email String getEmail() {

        return email;
    }

    public void setEmail(@NotBlank @Email String email) {

        this.email = email;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {

        this.cargo = cargo;
    }
}
