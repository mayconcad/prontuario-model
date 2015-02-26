package br.com.sts.ddum.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sts.ddum.model.entities.PrestacaoConta;

public interface PrestacaoContaRepository extends
		GenericRepository<PrestacaoConta>, JpaRepository<PrestacaoConta, Long> {

	public List<PrestacaoConta> autocompletar(Map<String, Object> params);

}
