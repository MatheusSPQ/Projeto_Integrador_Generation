package com.generation.rh_generation.controller;


import com.generation.rh_generation.model.Cargo;
import com.generation.rh_generation.model.Funcionario;
import com.generation.rh_generation.repository.CargoRepository;
import com.generation.rh_generation.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public ResponseEntity<List<Cargo>> getAll(){
        return ResponseEntity.ok(cargoRepository.findAll());
    }


    @GetMapping("/{cargo}")
    public ResponseEntity<List<Cargo>> getByNome(@PathVariable String cargo){
        List<Cargo> respostas = cargoRepository.findByNomeContainingIgnoreCase(cargo);
        if (respostas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respostas);
    }

}