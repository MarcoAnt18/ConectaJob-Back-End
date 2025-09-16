package com.grupo6.ConectaJob.Model.TempoSubdivicoes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class intervaloTempo {
    private LocalDate entrada;
    private LocalDate saida;

    public intervaloTempo() {}
}
