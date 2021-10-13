package br.com.frinfo.pontointeligente.service;

import br.com.frinfo.pontointeligente.model.Empresa;
import br.com.frinfo.pontointeligente.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Optional<Empresa> buscarPorCnpj(String cnpj){
        return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
    }

    public Empresa salvar(Empresa empresa){
        return empresaRepository.save(empresa);
    }
}
