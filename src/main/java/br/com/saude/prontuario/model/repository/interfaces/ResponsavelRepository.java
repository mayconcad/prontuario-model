package br.com.saude.prontuario.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.Responsavel;

public interface ResponsavelRepository extends GenericRepository<Responsavel>,
		JpaRepository<Responsavel, Long> {
}
