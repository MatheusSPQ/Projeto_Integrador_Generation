package com.generation.rh_generation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_cargos" )
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String nome;

    @NotNull
    private Double salarioBase;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo",cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties
    private List<Funcionario> funcionario;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 3, max = 255) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @Size(min = 3, max = 255) String nome) {
        this.nome = nome;
    }

    public @NotNull Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(@NotNull Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }
}
