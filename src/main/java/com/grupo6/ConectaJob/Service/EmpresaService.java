package com.grupo6.ConectaJob.Service;

import com.grupo6.ConectaJob.ExceptionsConfig.ExceptionsPerson.DuplicateEntityException;
import com.grupo6.ConectaJob.ExceptionsConfig.ExceptionsPerson.notFound;
import com.grupo6.ConectaJob.Model.DTO.*;
import com.grupo6.ConectaJob.Model.userEmpresa.EmpresaRepository;
import com.grupo6.ConectaJob.Model.userEmpresa.empresa;
import com.grupo6.ConectaJob.Model.userGeneric.UserGenericRepository;
import com.grupo6.ConectaJob.Model.vaga.vagaRepository;
import com.grupo6.ConectaJob.Model.vaga.vagaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public retornoEmpresaExiste buscaEmpresa (String cnpj){

        var empresaRequerida = empresaRepository.findEmpresaByCNPJ(cnpj);

        if (empresaRequerida == null){
            throw new notFound("Não existe empresa com CNPJ neste site !");
        }

        System.out.println(empresaRequerida);

        return new retornoEmpresaExiste(empresaRequerida.getCNPJ(),
                empresaRequerida.getNomeEmpresa(), empresaRequerida.getSegmento(),
                empresaRequerida.getFtPerfilLink(),empresaRequerida.getServicoPrestado());
    }

    public boolean createVaga (criarVagaDTO criarVagaDTO){
        var empresaResponvalel = empresaRepository.findEmpresaByCNPJ(criarVagaDTO.empresaReponsavelCNPJ());

        if (empresaResponvalel == null){
            throw new notFound("Empresa com este CNPJ no site não encontado");
        }

        //Verifica se a vaga já foi cadastrada na empresa
        vagaTrabalho VagaEncontrada = buscarVagaTrabalho(criarVagaDTO.servicoPrestadoNaOcasiao().getNomeServico(),
                criarVagaDTO.empresaReponsavelCNPJ());

        if(VagaEncontrada != null){
            throw new DuplicateEntityException("Vaga já cadastrada");
        }

        var vaga  = new vagaTrabalho
                (criarVagaDTO.empresaReponsavelCNPJ(),criarVagaDTO.servicoPrestadoNaOcasiao(),criarVagaDTO.cargo(),criarVagaDTO.jornadaAmpla(),
                        criarVagaDTO.jornandaDetalhada(), criarVagaDTO.numeroVagas());

        vagaRepository.save(vaga);

        return true;
    }

    public retornoVagaExistente BuscarVagaPorNome(searchVaga searchVaga){
        var empresaResponsavel = empresaRepository.findEmpresaByCNPJ(searchVaga.empresaResponsavelCNPJ());

        if (empresaResponsavel == null){
            throw new notFound("Empresa com este CNPJ no site não encontado");
        }

        vagaTrabalho VagaEncontrada = buscarVagaTrabalho(searchVaga.nomeVaga(), searchVaga.empresaResponsavelCNPJ());

        if(VagaEncontrada == null){
            throw new notFound("Vaga com esse nome não encontrada na empresa");
        }

        return new retornoVagaExistente(VagaEncontrada.getEmpresaReponsavelCNPJ(), VagaEncontrada.getServicoPrestadoNaOcasiao(),
                VagaEncontrada.getCargoIndividuo(), VagaEncontrada.getJornadaAmpla(), VagaEncontrada.getJornandaDetalhada(),
                VagaEncontrada.getNumeroDeVagasAbertas());

    }

    //Usado para procurar uma vaga no banco de dados pelo nome da vaga e CNPJ da empresa vinculada
    private vagaTrabalho buscarVagaTrabalho(String nomeVaga, String CNPJ) {
        List<vagaTrabalho> vagas = vagaRepository.findAll();
        vagaTrabalho VagaEncontrada = null;

        //Percorre as vagas cadastradas buscando pelo nome e CNPJ informado
        for(vagaTrabalho vaga : vagas){
            if(Objects.equals(vaga.getServicoPrestadoNaOcasiao().getNomeServico(), nomeVaga) &&
                    Objects.equals(vaga.getEmpresaReponsavelCNPJ(), CNPJ)) {
                VagaEncontrada = vaga;
            }
        }

        return VagaEncontrada;
    }

    public boolean deleteVaga (String nomeVaga, String CNPJ){
        var empresaResponsavel = empresaRepository.findEmpresaByCNPJ(CNPJ);

        if (empresaResponsavel == null){
            throw new notFound("Empresa com este CNPJ no site não encontado");
        }

        vagaTrabalho VagaEncontrada = buscarVagaTrabalho(nomeVaga, CNPJ);

        if(VagaEncontrada == null){
            throw new notFound("Vaga com esse nome não encontrada na empresa");
        }

        vagaRepository.delete(VagaEncontrada);

        return true;
    }

    public boolean editVaga(searchVaga searchVaga, novaVagaDTO novaVagaDTO){
        var empresaResponsavel = empresaRepository.findEmpresaByCNPJ(searchVaga.empresaResponsavelCNPJ());

        if (empresaResponsavel == null){
            throw new notFound("Empresa com este CNPJ no site não encontado");
        }

        vagaTrabalho VagaAntiga = buscarVagaTrabalho(searchVaga.nomeVaga(), searchVaga.empresaResponsavelCNPJ());

        if(VagaAntiga == null){
            throw new notFound("Vaga com esse nome não encontrada na empresa");
        }

        //Cria a nova vaga usando o construtor
        var NovaVaga = new vagaTrabalho(
                (novaVagaDTO.empresaReponsavelCNPJ() == null) ? VagaAntiga.getEmpresaReponsavelCNPJ() : novaVagaDTO.empresaReponsavelCNPJ(),
                (novaVagaDTO.servicoPrestadoNaOcasiao() == null) ? VagaAntiga.getServicoPrestadoNaOcasiao() : novaVagaDTO.servicoPrestadoNaOcasiao(),
                (novaVagaDTO.cargo() == null) ? VagaAntiga.getCargoIndividuo() : novaVagaDTO.cargo(),
                (novaVagaDTO.jornadaAmpla() == null) ? VagaAntiga.getJornadaAmpla() : novaVagaDTO.jornadaAmpla(),
                (novaVagaDTO.jornandaDetalhada() == null) ? VagaAntiga.getJornandaDetalhada() : novaVagaDTO.jornandaDetalhada(),
                (novaVagaDTO.numeroVagas() == null) ? VagaAntiga.getNumeroDeVagasAbertas() : novaVagaDTO.numeroVagas()
        );

        //SetID
        NovaVaga.setVagaId(VagaAntiga.getVagaId());

        //Adiciona ao banco de dados
        vagaRepository.save(NovaVaga);

        return true;
    }

    public List<vagaTrabalho> buscaTodasVagas (){
        return vagaRepository.findAll();
    }

}
