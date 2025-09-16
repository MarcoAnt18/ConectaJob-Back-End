package com.grupo6.ConectaJob.Model.TempoSubdivicoes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class intervaloTempoSalvosubCategorias {

    private List<intervaloTempo> jornadaCdescanco  = new ArrayList<>();
    private List<intervaloComString> jornadaSubCategorizada  = new ArrayList<>();
    public boolean jornadaCdescancoCreate (intervaloTempo jornandaPreDescanco, intervaloTempo intervaloDescanco, intervaloTempo jornadaPosDesanco){
            jornadaCdescanco.add(jornandaPreDescanco);
            jornadaCdescanco.add(intervaloDescanco);
            jornadaCdescanco.add(jornadaPosDesanco);
        return true;
    }
    public  List<intervaloComString> jornadaSubCategorizadaCreate (){
        return jornadaSubCategorizada;
    }
    public intervaloTempoSalvosubCategorias() {}
}
