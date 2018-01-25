package br.com.saude.prontuario.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.AuthoritySystem;

public interface AclRepository extends JpaRepository<AuthoritySystem, Long> {

}
