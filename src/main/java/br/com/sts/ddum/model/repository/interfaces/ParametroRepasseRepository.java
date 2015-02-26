package br.com.sts.ddum.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sts.ddum.model.entities.ParametroRepasse;

public interface ParametroRepasseRepository extends
		GenericRepository<ParametroRepasse>,
		JpaRepository<ParametroRepasse, Long> {

	public List<ParametroRepasse> autocompletar(Map<String, Object> params);

}
