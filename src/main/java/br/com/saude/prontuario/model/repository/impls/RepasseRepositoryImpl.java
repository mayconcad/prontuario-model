package br.com.saude.prontuario.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.saude.prontuario.model.entities.QRepasse;
import br.com.saude.prontuario.model.entities.QUnidade;
import br.com.saude.prontuario.model.entities.QUnidadeContabil;
import br.com.saude.prontuario.model.entities.Repasse;
import br.com.saude.prontuario.model.entities.UnidadeContabil;
import br.com.saude.prontuario.model.repository.interfaces.RepasseRepository;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional(readOnly = true)
public class RepasseRepositoryImpl extends QueryDslJpaRepository<Repasse, Long>
		implements RepasseRepository {

	private final QRepasse qRepasse = QRepasse.repasse;

	private final QUnidade qUnidade = QUnidade.unidade;

	private final QUnidadeContabil qUnidadeContabil = QUnidadeContabil.unidadeContabil;

	@Inject
	public RepasseRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Repasse, Long>(Repasse.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public List<Repasse> buscarPorNome(String nome) {
		return null;
	}

	@Override
	public List<Repasse> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("exercicio"))
			predicate.and(qRepasse.exercicio.eq(Integer.parseInt(params.get(
					"exercicio").toString())));
		if (params.containsKey("unidade.id"))
			predicate.and(qUnidade.id.eq(Long.parseLong(params
					.get("unidade.id").toString())));
		if (params.containsKey("unidade.responsavel.id"))
			predicate.and(qUnidade.responsavel.id.eq(Long.parseLong(params.get(
					"unidade.responsavel.id").toString())));
		// if (params.containsKey("codAtividade"))
		predicate.and(qRepasse.ativo.eq(true));

		return createQuery().innerJoin(qRepasse.unidade, qUnidade)
				.where(predicate).orderBy(qRepasse.numeroEmpenho.asc())
				.listDistinct(qRepasse);
		// return createQuery(predicate).orderBy(qRepasse.numeroEmpenho.asc())
		// .listDistinct(qRepasse);
	}

	@Override
	public List<Repasse> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		// predicate.or(qRepasse.descricao.containsIgnoreCase(valor));
		predicate.or(qRepasse.ativo.eq(true));
		return createQuery(predicate).orderBy(qRepasse.numeroEmpenho.asc())
				.listDistinct(qRepasse);
	}

	@Override
	public List<Repasse> autocompletar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("valor"))
			predicate.and(qRepasse.numeroEmpenho.eq(Long.parseLong(params.get(
					"valor").toString())));
		// if (params.containsKey("segmento"))
		// predicate.and(qRepasse.segmento.eq((SegmentoEnum) params
		// .get("segmento")));
		predicate.and(qRepasse.ativo.eq(true));
		return createQuery(predicate).orderBy(qRepasse.numeroEmpenho.asc())
				.listDistinct(qRepasse);
	}

	@Override
	public long obterProximoNumeroEmpenho(UnidadeContabil unidade) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(qRepasse.ativo.eq(true));
		predicate.and(qUnidadeContabil.id.eq(unidade.getId()));
		Long nexNumber = 0l;
		try {
			nexNumber = createQuery().innerJoin(qRepasse.unidade, qUnidade)
					.innerJoin(qUnidade.unidadeContabil, qUnidadeContabil)
					.where(predicate)
					.singleResult(qRepasse.numeroEmpenho.max());
		} catch (Exception e) {
			e.printStackTrace();
		}
		nexNumber = nexNumber == null ? 1 : 1 + nexNumber;
		return nexNumber;
	}
}
