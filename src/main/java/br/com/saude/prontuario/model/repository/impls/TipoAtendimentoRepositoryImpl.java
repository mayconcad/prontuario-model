package br.com.saude.prontuario.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.saude.prontuario.model.entities.TipoAtendimento;
import br.com.saude.prontuario.model.entities.QTipoAtendimento;
import br.com.saude.prontuario.model.repository.interfaces.TipoAtendimentoRepository;

import com.mysema.query.BooleanBuilder;

//import br.com.sts.prontuario.model.entities.QUserSystem;

@Repository
@Transactional(readOnly = true)
public class TipoAtendimentoRepositoryImpl extends QueryDslJpaRepository<TipoAtendimento, Long>
		implements TipoAtendimentoRepository {

	@Inject
	private EntityManager em;

	private static QTipoAtendimento TipoAtendimento = QTipoAtendimento.tipoAtendimento;

	@Inject
	public TipoAtendimentoRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<TipoAtendimento, Long>(TipoAtendimento.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public List<TipoAtendimento> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("descricao"))
			predicate.and(TipoAtendimento.descricao.lower().like(
					params.get("descricao").toString().toLowerCase()));
		predicate.and(TipoAtendimento.ativo.eq(true));
		return createQuery(predicate).orderBy(TipoAtendimento.descricao.asc()).listDistinct(
				TipoAtendimento);
	}

	@Override
	public List<TipoAtendimento> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(TipoAtendimento.descricao.containsIgnoreCase(valor));
		predicate.and(TipoAtendimento.ativo.eq(true));
		return createQuery(predicate).orderBy(TipoAtendimento.descricao.asc()).listDistinct(
				TipoAtendimento);
	}
}