package com.grupo6.ConectaJob.Model.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface repositoryUserTrabalhador extends JpaRepository <userTrabalhador,Long> {
    UserDetails findByCpf(String username);


}
