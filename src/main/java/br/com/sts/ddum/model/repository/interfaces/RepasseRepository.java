package br.com.sts.ddum.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sts.ddum.model.entities.Repasse;
import br.com.sts.ddum.model.entities.UnidadeContabil;

public interface RepasseRepository extends GenericRepository<Repasse>,
		JpaRepository<Repasse, Long> {

	public List<Repasse> autocompletar(Map<String, Object> params);

	public long obterProximoNumeroEmpenho(UnidadeContabil unidade);

}
