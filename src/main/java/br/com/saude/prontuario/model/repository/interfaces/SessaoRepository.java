package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

	List<Sessao> buscar(Map<String, Object> params);

	List<Sessao> autocompletar(String valor);

}
