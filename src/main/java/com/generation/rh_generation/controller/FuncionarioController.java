package com.generation.rh_generation.controller;
import com.generation.rh_generation.model.Funcionario;
import com.generation.rh_generation.repository.CargoRepository;
import com.generation.rh_generation.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;




@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoRepository cargoRepository;


    @PostMapping
    public ResponseEntity<Funcionario> post (@Valid @RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioRepository.save(funcionario));
    }


	@GetMapping
	public ResponseEntity<List<Funcionario>> getlALL(){

        return ResponseEntity.ok(funcionarioRepository.findAll());
	}

    @GetMapping("id/{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable Long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return funcionario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Funcionario>> getByCpf(@PathVariable String cpf){
        List<Funcionario> funcionarios = funcionarioRepository.findByCpf(cpf);
        if(funcionarios.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionarios);
    }

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

    @PutMapping
    public ResponseEntity<Funcionario> updateFuncionario(@Valid @RequestBody Funcionario funcionario) {
        if (funcionarioRepository.existsById(funcionario.getId())) {
            if (cargoRepository.existsById(funcionario.getCargo().getId()))
                return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(funcionario));

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionário não existente!", null);

        }
        return ResponseEntity.notFound().build();
    }




}
