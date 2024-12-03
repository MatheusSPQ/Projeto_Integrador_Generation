package com.generation.rh_generation.repository;

import com.generation.rh_generation.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository  extends JpaRepository<Cargo, Long> {

}
