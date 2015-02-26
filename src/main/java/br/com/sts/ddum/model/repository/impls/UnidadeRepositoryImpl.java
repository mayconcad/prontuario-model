package br.com.sts.ddum.model.repository.impls;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.model.entities.QUnidade;
import br.com.sts.ddum.model.entities.Unidade;
import br.com.sts.ddum.model.repository.interfaces.UnidadeRepository;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional(readOnly = true)
public class UnidadeRepositoryImpl extends QueryDslJpaRepository<Unidade, Long>
		implements UnidadeRepository {

	private final QUnidade qUnidade = QUnidade.unidade;

	@Inject
	public UnidadeRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Unidade, Long>(Unidade.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public List<Unidade> buscarPorNome(String nome) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(qUnidade.nome.containsIgnoreCase(nome));
		return createQuery(predicate).orderBy(qUnidade.nome.asc())
				.listDistinct(qUnidade);
	}

	@Override
	public List<Unidade> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("nome"))
			predicate.and(qUnidade.nome.containsIgnoreCase(params.get("nome")
					.toString()));
		if (params.containsKey("responsavel.id"))
			predicate.and(qUnidade.responsavel.id.eq(Long.parseLong(params.get(
					"responsavel.id").toString())));
		if (params.containsKey("parametroRepasse.id"))
			predicate.and(qUnidade.parametroRepasse.id.eq(Long.parseLong(params
					.get("parametroRepasse.id").toString())));
		if (params.containsKey("unidadeContabil.id"))
			predicate.and(qUnidade.unidadeContabil.id.eq(Long.parseLong(params
					.get("unidadeContabil.id").toString())));
		if (params.containsKey("parametroRepasse.valorRepasse"))
			predicate.and(qUnidade.parametroRepasse.valorRepasse
					.eq(new BigDecimal(params.get(
							"parametroRepasse.valorRepasse").toString())));
		predicate.and(qUnidade.ativo.eq(true));
		return createQuery(predicate).orderBy(qUnidade.nome.asc())
				.listDistinct(qUnidade);
	}

	@Override
	public List<Unidade> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.or(qUnidade.nome.containsIgnoreCase(valor));
		predicate.and(qUnidade.ativo.eq(true));
		return createQuery(predicate).orderBy(qUnidade.nome.asc())
				.listDistinct(qUnidade);
	}
}
