package br.com.saude.prontuario.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.saude.prontuario.model.entities.QResponsavel;
import br.com.saude.prontuario.model.entities.Responsavel;
import br.com.saude.prontuario.model.repository.interfaces.ResponsavelRepository;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional(readOnly = true)
public class ResponsavelRepositoryImpl extends
		QueryDslJpaRepository<Responsavel, Long> implements
		ResponsavelRepository {

	private static final QResponsavel qResponsavel = QResponsavel.responsavel;

	@Inject
	public ResponsavelRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Responsavel, Long>(
				Responsavel.class, entityManager.getMetamodel()), entityManager);
	}

	@Override
	public List<Responsavel> buscarPorNome(String nome) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.or(qResponsavel.nome.containsIgnoreCase(nome));
		predicate.and(qResponsavel.ativo.eq(true));
		return createQuery(predicate).orderBy(qResponsavel.nome.asc())
				.listDistinct(qResponsavel);
	}

	@Override
	public List<Responsavel> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("nome"))
			predicate.and(qResponsavel.nome.containsIgnoreCase(params.get(
					"nome").toString()));
		if (params.containsKey("matriculaFuncional"))
			predicate.and(qResponsavel.matriculaFuncional
					.containsIgnoreCase(params.get("matriculaFuncional")
							.toString()));
		if (params.containsKey("rg"))
			predicate.and(qResponsavel.rg.containsIgnoreCase(params.get("rg")
					.toString()));
		if (params.containsKey("cpf"))
			predicate.and(qResponsavel.cpf.containsIgnoreCase(params.get("cpf")
					.toString()));
		if (params.containsKey("cargo"))
			predicate.and(qResponsavel.cargo.containsIgnoreCase(params.get(
					"cargo").toString()));
		if (params.containsKey("user.id"))
			predicate.and(qResponsavel.user.id.eq(Long.parseLong(params.get(
					"user.id").toString())));
		predicate.and(qResponsavel.ativo.eq(true));
		return createQuery(predicate).orderBy(qResponsavel.nome.asc())
				.listDistinct(qResponsavel);
	}

	@Override
	public List<Responsavel> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.or(qResponsavel.nome.containsIgnoreCase(valor));
		predicate.or(qResponsavel.matriculaFuncional.containsIgnoreCase(valor));
		predicate.and(qResponsavel.ativo.eq(true));
		return createQuery(predicate).orderBy(qResponsavel.nome.asc())
				.listDistinct(qResponsavel);
	}
}
