package com.generation.rh_generation.controller;

import com.generation.rh_generation.model.Funcionario;
import com.generation.rh_generation.repository.CargoRepository;
import com.generation.rh_generation.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    CargoRepository cargoRepository;


    @PutMapping
    public ResponseEntity<Funcionario> updateFuncionario(@Valid @RequestBody Funcionario funcionario) {
        if (funcionarioRepository.existsById(funcionario.getId())) {
            if (cargoRepository.existsById(funcionario.getCargo().getId()))
                return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(funcionario));

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionário não existente!", null);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Funcionario>> getByCpf(@PathVariable String cpf){
        List<Funcionario> funcionarios = funcionarioRepository.findByCpf(cpf);
        if(funcionarios.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionarios);
    }


}
