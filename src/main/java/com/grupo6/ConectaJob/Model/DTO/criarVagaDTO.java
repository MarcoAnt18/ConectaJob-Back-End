package com.grupo6.ConectaJob.Model.DTO;

import com.grupo6.ConectaJob.Model.TempoSubdivicoes.intervaloTempo;
import com.grupo6.ConectaJob.Model.TempoSubdivicoes.intervaloTempoSalvosubCategorias;
import com.grupo6.ConectaJob.Model.cargo.cargo;
import com.grupo6.ConectaJob.Model.userEmpresa.servicoPrestado;

public record criarVagaDTO(String empresaReponsavelId,
servicoPrestado servicoPrestadoNaOcasiao, cargo cargo, intervaloTempo jornadaAmpla,
intervaloTempoSalvosubCategorias jornandaDetalhada, int numeroVagas){
}
