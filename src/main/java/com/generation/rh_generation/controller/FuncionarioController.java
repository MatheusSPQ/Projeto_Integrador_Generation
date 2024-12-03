package com.generation.rh_generation.controller;

import com.generation.rh_generation.model.Funcionario;
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
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    CargoRepository cargoRepository;
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
    	Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
    	if (funcionarioOptional.isPresent()) {
    		funcionarioRepository.deleteById(id);
    		return ResponseEntity.ok("Funcionário deletado com sucesso.");
    	} else {
    		return ResponseEntity.status(404).body("Funcionário não encontrado.");
    	}
    	
    }
}
