package com.grupo6.ConectaJob.Controller.Busca;

import com.grupo6.ConectaJob.Model.DTO.retornoEmpresaExiste;
import com.grupo6.ConectaJob.Model.DTO.searchDTO;
import com.grupo6.ConectaJob.Model.userEmpresa.empresa;
import com.grupo6.ConectaJob.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Search/Empresas")
public class buscaEmpresas {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<retornoEmpresaExiste> testeToken (@RequestBody searchDTO searchCNPJ){
        return ResponseEntity.ok(empresaService.buscaEmpresa(searchCNPJ.cnpj()));
    }
}
