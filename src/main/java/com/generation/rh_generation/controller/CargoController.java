package com.generation.rh_generation.controller;


import com.generation.rh_generation.model.Cargo;
import com.generation.rh_generation.repository.CargoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
