package com.grupo6.ConectaJob.Model.cargo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargoRespository extends JpaRepository<Cargo, Integer> {

    //Implementa a busca por nome
    Optional<Cargo> findByNomeCargo(String nome);

    //Marcação para não realizar a ação caso de algum erro
    @Transactional
    void deleteByNomeCargo(String nome);
}
