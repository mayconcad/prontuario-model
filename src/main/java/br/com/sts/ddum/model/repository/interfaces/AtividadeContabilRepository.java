package br.com.sts.ddum.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sts.ddum.model.entities.AtividadeContabil;

public interface AtividadeContabilRepository extends
		GenericRepository<AtividadeContabil>,
		JpaRepository<AtividadeContabil, Long> {
}
