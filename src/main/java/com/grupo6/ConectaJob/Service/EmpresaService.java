package com.grupo6.ConectaJob.Service;

import com.grupo6.ConectaJob.ExceptionsConfig.ExceptionsPerson.notFound;
import com.grupo6.ConectaJob.Model.DTO.createEmpresaDTO;
import com.grupo6.ConectaJob.Model.DTO.criarVagaDTO;
import com.grupo6.ConectaJob.Model.userEmpresa.EmpresaRepository;
import com.grupo6.ConectaJob.Model.userEmpresa.empresa;
import com.grupo6.ConectaJob.Model.userGeneric.UserGenericRepository;
import com.grupo6.ConectaJob.Model.vaga.vagaRepository;
import com.grupo6.ConectaJob.Model.vaga.vagaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private UserGenericRepository UserGenericRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private vagaRepository vagaRepository;
    public boolean createEmpresa (createEmpresaDTO crateEmpresaDTO){
        var representante = UserGenericRepository.findByCpf(crateEmpresaDTO.CPFatrelado());

        if (representante == null){
            throw new notFound("Usuario com este CPF no site não encontado");
        }

        var novaEmpresa = new empresa(crateEmpresaDTO.CPFatrelado(), crateEmpresaDTO.CNPJ(),
        crateEmpresaDTO.nomeEmpresa(),crateEmpresaDTO.segmento(), crateEmpresaDTO.servicoPrestadoList());

        empresaRepository.save(novaEmpresa);
        return true;
    }

    public boolean createVaga (criarVagaDTO criarVagaDTO){
        var empresaResponvalel = empresaRepository.findEmpresaByID(criarVagaDTO.empresaReponsavelId());

        if (empresaResponvalel == null){
            throw new notFound("Empresa com este id no site não encontado");
        }

        var vaga  = new vagaTrabalho
        (criarVagaDTO.empresaReponsavelId(),criarVagaDTO.servicoPrestadoNaOcasiao(),criarVagaDTO.cargo(),criarVagaDTO.jornadaAmpla(),
        criarVagaDTO.jornandaDetalhada(), criarVagaDTO.numeroVagas());

        vagaRepository.save(vaga);

        return true;
    }

}
