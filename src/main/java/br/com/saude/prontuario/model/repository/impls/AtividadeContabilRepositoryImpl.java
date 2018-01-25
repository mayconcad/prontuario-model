package br.com.saude.prontuario.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.saude.prontuario.model.entities.AtividadeContabil;
import br.com.saude.prontuario.model.entities.QAtividadeContabil;
import br.com.saude.prontuario.model.repository.interfaces.AtividadeContabilRepository;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional(readOnly = true)
public class AtividadeContabilRepositoryImpl extends
		QueryDslJpaRepository<AtividadeContabil, Long> implements
		AtividadeContabilRepository {

	private static final QAtividadeContabil qAtividadeContabil = QAtividadeContabil.atividadeContabil;

	@Inject
	public AtividadeContabilRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<AtividadeContabil, Long>(
				AtividadeContabil.class, entityManager.getMetamodel()),
				entityManager);
	}

	@Override
	public List<AtividadeContabil> buscarPorNome(String nome) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.or(qAtividadeContabil.descricao.containsIgnoreCase(nome));
		predicate.and(qAtividadeContabil.ativo.eq(true));
		return createQuery(predicate).orderBy(
				qAtividadeContabil.descricao.asc()).listDistinct(
				qAtividadeContabil);
	}

	@Override
	public List<AtividadeContabil> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("descricao"))
			predicate.and(qAtividadeContabil.descricao
					.containsIgnoreCase(params.get("descricao").toString()));
		if (params.containsKey("codigo"))
			predicate.and(qAtividadeContabil.codigo.containsIgnoreCase(params
					.get("codigo").toString()));
		if (params.containsKey("contaContabil.id"))
			predicate.and(qAtividadeContabil.contaContabil.id.eq(Long
					.parseLong(params.get("contaContabil.id").toString())));
		return createQuery(predicate).orderBy(
				qAtividadeContabil.descricao.asc()).listDistinct(
				qAtividadeContabil);
	}

	@Override
	public List<AtividadeContabil> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.or(qAtividadeContabil.descricao.containsIgnoreCase(valor));
		predicate.and(qAtividadeContabil.ativo.eq(true));
		return createQuery(predicate).orderBy(
				qAtividadeContabil.descricao.asc()).listDistinct(
				qAtividadeContabil);
	}
}
