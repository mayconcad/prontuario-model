package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

	List<Sala> buscar(Map<String, Object> params);

	List<Sala> autocompletar(String valor);

}
