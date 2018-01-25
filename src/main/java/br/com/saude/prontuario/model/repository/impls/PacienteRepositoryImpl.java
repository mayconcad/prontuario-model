package br.com.saude.prontuario.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.saude.prontuario.model.entities.Paciente;
import br.com.saude.prontuario.model.entities.QPaciente;
import br.com.saude.prontuario.model.repository.interfaces.PacienteRepository;

import com.mysema.query.BooleanBuilder;

//import br.com.sts.prontuario.model.entities.QUserSystem;

@Repository
@Transactional(readOnly = true)
public class PacienteRepositoryImpl extends QueryDslJpaRepository<Paciente, Long>
		implements PacienteRepository {

	@Inject
	private EntityManager em;

	private static QPaciente Paciente = QPaciente.paciente;

	@Inject
	public PacienteRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Paciente, Long>(Paciente.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public List<Paciente> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("nome"))
			predicate.and(Paciente.nome.lower().like(
					params.get("name").toString().toLowerCase()));
		predicate.and(Paciente.ativo.eq(true));
		return createQuery(predicate).orderBy(Paciente.nome.asc()).listDistinct(
				Paciente);
	}

	@Override
	public List<Paciente> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(Paciente.nome.containsIgnoreCase(valor));
		predicate.and(Paciente.ativo.eq(true));
		return createQuery(predicate).orderBy(Paciente.nome.asc()).listDistinct(
				Paciente);
	}
}