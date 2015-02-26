package br.com.sts.ddum.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.domain.entities.QUnidadeContabil;
import br.com.sts.ddum.model.entities.UnidadeContabil;
import br.com.sts.ddum.model.repository.interfaces.UnidadeContabilRepository;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional(readOnly = true)
public class UnidadeContabilRepositoryImpl extends
		QueryDslJpaRepository<UnidadeContabil, Long> implements
		UnidadeContabilRepository {

	private final QUnidadeContabil qUnidadeContabil = QUnidadeContabil.unidadeContabil;

	@Inject
	public UnidadeContabilRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<UnidadeContabil, Long>(
				UnidadeContabil.class, entityManager.getMetamodel()),
				entityManager);
	}

	@Override
	public List<UnidadeContabil> buscarPorNome(String nome) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.or(qUnidadeContabil.nome.containsIgnoreCase(nome));
		predicate.and(qUnidadeContabil.ativo.eq(true));
		return createQuery(predicate).orderBy(qUnidadeContabil.nome.asc())
				.listDistinct(qUnidadeContabil);
	}

	@Override
	public List<UnidadeContabil> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("nome"))
			predicate.or(qUnidadeContabil.nome.containsIgnoreCase(params.get(
					"nome").toString()));
		predicate.and(qUnidadeContabil.ativo.eq(true));
		return createQuery(predicate).orderBy(qUnidadeContabil.nome.asc())
				.listDistinct(qUnidadeContabil);
	}

	@Override
	public List<UnidadeContabil> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.or(qUnidadeContabil.nome.containsIgnoreCase(valor));
		predicate.and(qUnidadeContabil.ativo.eq(true));
		return createQuery(predicate).orderBy(qUnidadeContabil.nome.asc())
				.listDistinct(qUnidadeContabil);
	}

}
