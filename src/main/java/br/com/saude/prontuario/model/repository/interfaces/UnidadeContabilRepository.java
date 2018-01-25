package br.com.saude.prontuario.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.UnidadeContabil;

public interface UnidadeContabilRepository extends
		GenericRepository<UnidadeContabil>,
		JpaRepository<UnidadeContabil, Long> {

}
