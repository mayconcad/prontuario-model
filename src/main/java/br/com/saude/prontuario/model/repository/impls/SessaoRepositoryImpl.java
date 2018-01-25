package br.com.saude.prontuario.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.saude.prontuario.model.entities.Sessao;
import br.com.saude.prontuario.model.entities.QSessao;
import br.com.saude.prontuario.model.repository.interfaces.SessaoRepository;

import com.mysema.query.BooleanBuilder;

//import br.com.sts.prontuario.model.entities.QUserSystem;

@Repository
@Transactional(readOnly = true)
public class SessaoRepositoryImpl extends QueryDslJpaRepository<Sessao, Long>
		implements SessaoRepository {

	@Inject
	private EntityManager em;

	private static QSessao Sessao = QSessao.sessao;

	@Inject
	public SessaoRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Sessao, Long>(Sessao.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public List<Sessao> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if(params.containsKey("id"))
		predicate.and(Sessao.id.eq(Long
				.parseLong(params.get("id").toString())));
		if (params.containsKey("descricao"))
			predicate.and(Sessao.descricao.lower().like(
					params.get("descricao").toString().toLowerCase()));
		//predicate.and(Sessao.ativo.eq(true));
		return createQuery(predicate).orderBy(Sessao.descricao.asc()).listDistinct(
				Sessao);
	}

	@Override
	public List<Sessao> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(Sessao.descricao.containsIgnoreCase(valor));
		predicate.and(Sessao.ativo.eq(true));
		return createQuery(predicate).orderBy(Sessao.descricao.asc()).listDistinct(
				Sessao);
	}
}