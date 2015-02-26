package br.com.sts.ddum.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sts.ddum.model.entities.UnidadeContabil;

public interface UnidadeContabilRepository extends
		GenericRepository<UnidadeContabil>,
		JpaRepository<UnidadeContabil, Long> {

}
