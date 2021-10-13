package br.com.frinfo.pontointeligente.service;

import br.com.frinfo.pontointeligente.model.Lancamento;
import br.com.frinfo.pontointeligente.repository.LancamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {
    private LancamentoRepository lancamentoRepository;

    public LancamentoService(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, Pageable pageable){
        return lancamentoRepository.findByFuncionarioId(funcionarioId, pageable);
    }

    public Optional<Lancamento> buscarPorId(Long id){
        return lancamentoRepository.findById(id);
    }

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public void deletar(Long id){
        lancamentoRepository.deleteById(id);
    }
}
