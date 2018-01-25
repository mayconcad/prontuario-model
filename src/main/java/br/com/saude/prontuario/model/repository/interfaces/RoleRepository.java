package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.springsecurity.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> buscar(Map<String, Object> params);

	List<Role> autocompletar(String valor);

}
