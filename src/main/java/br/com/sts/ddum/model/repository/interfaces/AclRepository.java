package br.com.sts.ddum.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sts.ddum.model.entities.AuthoritySystem;

public interface AclRepository extends JpaRepository<AuthoritySystem, Long> {

}
