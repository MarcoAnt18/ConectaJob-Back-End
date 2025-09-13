package com.grupo6.ConectaJob.Controller;

import com.grupo6.ConectaJob.Service.CargoService;
import com.grupo6.ConectaJob.Model.cargo.Cargo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TESTE
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    //Dependência do CargoService
    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarCargo(@RequestBody Cargo cargo){
        cargoService.salvarCargo(cargo);
        return  ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Cargo> buscarCargoPorNome(@RequestParam String nome){
        return ResponseEntity.ok(cargoService.buscarCargoPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPorNome(@RequestParam String nome){
        cargoService.deletarCargoPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarCargoPorNome(@RequestParam String nome, @RequestBody Cargo cargo){
        cargoService.atualizarCargoPorNome(nome, cargo);
        return ResponseEntity.ok().build();
    }
}
