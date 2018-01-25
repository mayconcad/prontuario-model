package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.Unidade;

public interface UnidadeRepository extends GenericRepository<Unidade>,
		JpaRepository<Unidade, Long> {

	List<Unidade> autocompletarPorResponsavel(String valor, long responsavelId);
}
