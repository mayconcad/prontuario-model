package br.com.sts.ddum.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sts.ddum.model.entities.Responsavel;

public interface ResponsavelRepository extends GenericRepository<Responsavel>,
		JpaRepository<Responsavel, Long> {
}
