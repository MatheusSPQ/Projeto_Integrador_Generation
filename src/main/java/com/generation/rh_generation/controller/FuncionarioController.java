package com.generation.rh_generation.controller;

import com.generation.rh_generation.model.Funcionario;
import com.generation.rh_generation.repository.CargoRepository;
import com.generation.rh_generation.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    CargoRepository cargoRepository;


    @PostMapping
    public ResponseEntity<Funcionario> post (@Valid @RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioRepository.save(funcionario));
    }

}
