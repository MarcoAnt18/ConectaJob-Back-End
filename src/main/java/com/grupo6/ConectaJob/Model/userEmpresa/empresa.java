package com.grupo6.ConectaJob.Model.userEmpresa;

import com.grupo6.ConectaJob.Model.listaAvaliacoesSegundoCargo;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user_empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class empresa {
    @Id
    private String id;
    private String CPFatrelado;
    private String CNPJ;
    private String nomeEmpresa;
    private String segmento;
    private String ftPerfilLink;
    private List<servicoPrestado> servicoPrestado;
    private listaAvaliacoesSegundoCargo avaliacoesSegundoCargo;

    public empresa(String CPFatrelado, String CNPJ, String nomeEmpresa,
                   String segmento,List<servicoPrestado> servicoPrestado) {

        this.CPFatrelado = CPFatrelado;
        this.CNPJ = CNPJ;
        this.nomeEmpresa = nomeEmpresa;
        this.segmento = segmento;
        this.servicoPrestado = servicoPrestado;
    }
}
