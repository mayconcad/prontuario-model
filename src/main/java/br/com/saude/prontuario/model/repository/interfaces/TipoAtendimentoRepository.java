package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.TipoAtendimento;

public interface TipoAtendimentoRepository extends JpaRepository<TipoAtendimento, Long> {

	List<TipoAtendimento> buscar(Map<String, Object> params);

	List<TipoAtendimento> autocompletar(String valor);

}
