package br.com.saude.prontuario.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.saude.prontuario.model.entities.Atendimento;
import br.com.saude.prontuario.model.entities.QAtendimento;
import br.com.saude.prontuario.model.repository.interfaces.AtendimentoRepository;

import com.mysema.query.BooleanBuilder;

//import br.com.sts.prontuario.model.entities.QUserSystem;

@Repository
@Transactional(readOnly = true)
public class AtendimentoRepositoryImpl extends QueryDslJpaRepository<Atendimento, Long>
		implements AtendimentoRepository {

	@Inject
	private EntityManager em;

	private static QAtendimento atendimento = QAtendimento.atendimento;

	@Inject
	public AtendimentoRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Atendimento, Long>(Atendimento.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public List<Atendimento> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("descricao"))
			predicate.and(atendimento.descricao.lower().like(
					params.get("descricao").toString().toLowerCase()));
		if (params.containsKey("paciente.id"))
			predicate.and(atendimento.paciente.id.eq(Long
					.parseLong(params.get("paciente.id").toString())));
		predicate.and(atendimento.ativo.eq(true));
		return createQuery(predicate).orderBy(atendimento.id.desc()).listDistinct(
				atendimento);
			
	}

	@Override
	public List<Atendimento> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(atendimento.descricao.containsIgnoreCase(valor));
		predicate.and(atendimento.ativo.eq(true));
		return createQuery(predicate).orderBy(atendimento.descricao.asc()).listDistinct(
				atendimento);
	}
}