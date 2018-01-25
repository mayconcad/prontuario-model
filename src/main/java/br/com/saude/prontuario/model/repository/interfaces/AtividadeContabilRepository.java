package br.com.saude.prontuario.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.AtividadeContabil;

public interface AtividadeContabilRepository extends
		GenericRepository<AtividadeContabil>,
		JpaRepository<AtividadeContabil, Long> {
}
