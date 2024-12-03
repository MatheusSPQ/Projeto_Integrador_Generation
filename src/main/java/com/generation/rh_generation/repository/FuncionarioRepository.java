package com.generation.rh_generation.repository;

import com.generation.rh_generation.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {
    public List<Funcionario> findByCpf(@Param("cpf") String cpf);
}
