package br.com.sts.ddum.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sts.ddum.model.entities.Unidade;

public interface UnidadeRepository extends GenericRepository<Unidade>,
		JpaRepository<Unidade, Long> {
}
