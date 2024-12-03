package com.generation.rh_generation.repository;

import com.generation.rh_generation.model.Cargo;
import com.generation.rh_generation.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {

}
