package com.generation.rh_generation.controller;
import com.generation.rh_generation.model.Cargo;
import com.generation.rh_generation.repository.CargoRepository;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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




    @PostMapping
    public ResponseEntity<Cargo> post(@Valid @RequestBody Cargo cargo){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cargoRepository.save(cargo));
    }

    
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

    @PutMapping
    public ResponseEntity<Cargo> updateCargo(@Valid @RequestBody Cargo cargo) {
        return cargoRepository.findById(cargo.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(cargoRepository.save(cargo)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


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


   

