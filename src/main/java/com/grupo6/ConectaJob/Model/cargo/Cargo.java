package com.grupo6.ConectaJob.Model.cargo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Cargo")
@Entity
public class Cargo {

    //Gera o ID de cada elemento da tabela
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nomeCargo")
    private String nomeCargo;

    @Column(name = "visaoCargo")
    private String visaoCargo;

    @Column(name = "desempenhoCargo")
    private String desempenhoCargo;

    @Column(name = "horario")
    private String horario;

    @Column(name = "espacoTrabalho")
    private String espacoTrabalho;
}