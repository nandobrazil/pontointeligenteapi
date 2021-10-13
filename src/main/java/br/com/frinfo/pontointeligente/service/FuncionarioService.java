package br.com.frinfo.pontointeligente.service;

import br.com.frinfo.pontointeligente.model.Funcionario;
import br.com.frinfo.pontointeligente.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorCpf(String cpf){
        return Optional.ofNullable(funcionarioRepository.findByCpf(cpf));
    }

    public Optional<Funcionario> buscarPorEmail(String email){
        return Optional.ofNullable(funcionarioRepository.findByEmail(email));
    }

    public Optional<Funcionario> buscarPorId(Long id){
        return funcionarioRepository.findById(id);
    }
}
