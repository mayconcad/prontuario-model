package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.springsecurity.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User loadUserByUsername(String username);

	void changePassword(String userName, String newPassword);

	User loadCurrentUser();

	List<User> buscar(Map<String, Object> params);

}
