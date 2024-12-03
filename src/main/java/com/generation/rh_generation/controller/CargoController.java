package com.generation.rh_generation.controller;


import com.generation.rh_generation.model.Cargo;
import com.generation.rh_generation.repository.CargoRepository;
import com.generation.rh_generation.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PutMapping
    public ResponseEntity<Cargo> updateCargo(@Valid @RequestBody Cargo cargo) {
        return cargoRepository.findById(cargo.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(cargoRepository.save(cargo)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());



    }







}
