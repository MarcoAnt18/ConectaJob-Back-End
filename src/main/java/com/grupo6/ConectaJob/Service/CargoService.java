package com.grupo6.ConectaJob.Service;

import com.grupo6.ConectaJob.Model.cargo.Cargo;
import com.grupo6.ConectaJob.Model.cargo.CargoRespository;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    //Injeção de dependência do CargoRepository
    private final CargoRespository respository;

    public CargoService(CargoRespository respository) {
        this.respository = respository;
    }

    public void salvarCargo(Cargo cargo){
        respository.saveAndFlush(cargo);
    }

    public Cargo buscarCargoPorNome(String nome){
        return respository.findByNomeCargo(nome).orElseThrow(
                //ENTENDER ESSE JEITO E CRIAR CLASSE DE ERRO
                () -> new RuntimeException("Nome não encontrado")
        );
    }

    public void deletarCargoPorNome(String nome){
        respository.deleteByNomeCargo(nome);
    }

    public void atualizarCargoPorNome(String nome, Cargo cargo){
        //COLOCAR O ERRO PARA CASO NÃO ENCONTRAR O NOME
        Cargo cargoEntity = buscarCargoPorNome(nome);
        Cargo cargoAtualizado = Cargo.builder()
                .nomeCargo(cargo.getNomeCargo() != null ? cargo.getNomeCargo() : cargoEntity.getNomeCargo())
                .visaoCargo(cargo.getVisaoCargo() != null ? cargo.getVisaoCargo() : cargoEntity.getVisaoCargo())
                .desempenhoCargo(cargo.getDesempenhoCargo() != null ? cargo.getDesempenhoCargo() : cargoEntity.getDesempenhoCargo())
                .horario(cargo.getHorario() != null ? cargo.getHorario() : cargoEntity.getHorario())
                .espacoTrabalho(cargo.getEspacoTrabalho() != null ? cargo.getEspacoTrabalho() : cargoEntity.getEspacoTrabalho())
                .id(cargoEntity.getId())
                .build();

        respository.saveAndFlush(cargoAtualizado);
    }
}
