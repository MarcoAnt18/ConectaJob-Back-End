package com.grupo6.ConectaJob.ConfgSeguranca;

import com.grupo6.ConectaJob.Model.usuario.repositoryUserTrabalhador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginRecuperaInfoUser implements UserDetailsService {
    @Autowired
    private repositoryUserTrabalhador repositoryUserTrabalhador;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUserTrabalhador.findBycpf(username);
    }
}
