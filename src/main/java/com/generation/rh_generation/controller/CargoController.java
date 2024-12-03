package com.generation.rh_generation.controller;


import com.generation.rh_generation.model.Cargo;
import com.generation.rh_generation.repository.CargoRepository;
import com.generation.rh_generation.repository.FuncionarioRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCargo(@PathVariable Long id) {
    	Optional<Cargo> cargoOptional = cargoRepository.findById(id);
    	if (cargoOptional.isPresent()) {
    		cargoRepository.deleteById(id);
    		return ResponseEntity.ok("Cargo deletado com sucesso.");
    	}  else  {
    		return ResponseEntity.status(404).body("Cargo não encontrado.");
    	}
    	}
    }










