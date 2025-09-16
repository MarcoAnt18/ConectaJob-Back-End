package com.grupo6.ConectaJob.Model.vaga;

import com.grupo6.ConectaJob.Model.TempoSubdivicoes.intervaloTempo;
import com.grupo6.ConectaJob.Model.TempoSubdivicoes.intervaloTempoSalvosubCategorias;
import com.grupo6.ConectaJob.Model.cargo.cargo;
import com.grupo6.ConectaJob.Model.userEmpresa.servicoPrestado;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vaga")
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

    public vagaTrabalho() {
    }

    public String getVagaId() {
        return vagaId;
    }

    public void setVagaId(String vagaId) {
        this.vagaId = vagaId;
    }

    public String getEmpresaReponsavelId() {
        return empresaReponsavelId;
    }

    public void setEmpresaReponsavelId(String empresaReponsavelId) {
        this.empresaReponsavelId = empresaReponsavelId;
    }

    public servicoPrestado getServicoPrestadoNaOcasiao() {
        return servicoPrestadoNaOcasiao;
    }

    public void setServicoPrestadoNaOcasiao(servicoPrestado servicoPrestadoNaOcasiao) {
        this.servicoPrestadoNaOcasiao = servicoPrestadoNaOcasiao;
    }

    public cargo getCargoIndividuo() {
        return cargo;
    }

    public void setCargoIndividuo(cargo cargoIndividuo) {
        this.cargo = cargoIndividuo;
    }

    public intervaloTempo getJornadaAmpla() {
        return jornadaAmpla;
    }

    public void setJornadaAmpla(intervaloTempo jornadaAmpla) {
        this.jornadaAmpla = jornadaAmpla;
    }

    public intervaloTempoSalvosubCategorias getJornandaDetalhada() {
        return jornandaDetalhada;
    }

    public void setJornandaDetalhada(intervaloTempoSalvosubCategorias jornandaDetalhada) {
        this.jornandaDetalhada = jornandaDetalhada;
    }

    public int getNumeroDeVagasAbertas() {
        return numeroDeVagasAbertas;
    }

    public void setNumeroDeVagasAbertas(int numeroDeVagasAbertas) {
        this.numeroDeVagasAbertas = numeroDeVagasAbertas;
    }
}
