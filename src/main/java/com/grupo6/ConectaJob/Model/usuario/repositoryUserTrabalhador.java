package com.grupo6.ConectaJob.Model.usuario;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface repositoryUserTrabalhador extends MongoRepository <userTrabalhador,String> {
    UserDetails findByCpf(String username);


}
