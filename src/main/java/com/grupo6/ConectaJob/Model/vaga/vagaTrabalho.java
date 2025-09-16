package com.grupo6.ConectaJob.Model.vaga;

import com.grupo6.ConectaJob.Model.TempoSubdivicoes.intervaloTempo;
import com.grupo6.ConectaJob.Model.TempoSubdivicoes.intervaloTempoSalvosubCategorias;
import com.grupo6.ConectaJob.Model.cargo.cargo;
import com.grupo6.ConectaJob.Model.userEmpresa.servicoPrestado;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vaga")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class vagaTrabalho {
    @Id
    private String vagaId;
    private String empresaReponsavelId;
    private servicoPrestado servicoPrestadoNaOcasiao;
    private cargo cargo;
    private intervaloTempo jornadaAmpla;
    private intervaloTempoSalvosubCategorias jornandaDetalhada;
    private int numeroDeVagasAbertas;

    public vagaTrabalho(String empresaReponsavelId, servicoPrestado servicoPrestadoNaOcasiao,
        cargo cargoIndividuo, intervaloTempo jornadaAmpla, intervaloTempoSalvosubCategorias jornandaDetalhada,
        int numeroDeVagasAbertas) {

        this.empresaReponsavelId = empresaReponsavelId;
        this.servicoPrestadoNaOcasiao = servicoPrestadoNaOcasiao;
        this.cargo = cargoIndividuo;
        this.jornadaAmpla = jornadaAmpla;
        this.jornandaDetalhada = jornandaDetalhada;
        this.numeroDeVagasAbertas = numeroDeVagasAbertas;
    }
}
