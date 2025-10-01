package com.grupo6.ConectaJob.Controller.Update;

import com.grupo6.ConectaJob.Model.DTO.editVagaDTO;
import com.grupo6.ConectaJob.Model.DTO.novaVagaDTO;
import com.grupo6.ConectaJob.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Update")
public class UpdateEmpresa {

    @Autowired
    private EmpresaService empresaService;

    @PutMapping("/Vaga")
    public boolean editarVaga(@RequestBody editVagaDTO editVagaDTO){
        empresaService.editVaga(editVagaDTO.searchVaga(), editVagaDTO.novaVagaDTO());
        return true;
    }
}
