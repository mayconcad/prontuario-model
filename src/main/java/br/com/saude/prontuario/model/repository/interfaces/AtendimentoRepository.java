package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

	List<Atendimento> buscar(Map<String, Object> params);

	List<Atendimento> autocompletar(String valor);

}
