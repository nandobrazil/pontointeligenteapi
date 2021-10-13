package br.com.frinfo.pontointeligente.repository;

import br.com.frinfo.pontointeligente.model.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
@NamedQueries({
    @NamedQuery(name = "LancamentoRepository.findByFuncionarioId",
                query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId")})
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
    Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);

}
