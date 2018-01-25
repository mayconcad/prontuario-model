package br.com.saude.prontuario.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saude.prontuario.model.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	List<Paciente> buscar(Map<String, Object> params);

	List<Paciente> autocompletar(String valor);

}
