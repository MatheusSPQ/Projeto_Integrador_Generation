package com.generation.rh_generation.repository;

import com.generation.rh_generation.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    public List<Cargo> findByNomeContainingIgnoreCase(@Param("nome") String nome);
}



