package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.ParametroRepasse;

public interface ParametroRepasseRepository extends
		GenericRepository<ParametroRepasse>,
		JpaRepository<ParametroRepasse, Long> {

	public List<ParametroRepasse> autocompletar(Map<String, Object> params);

}
