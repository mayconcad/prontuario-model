package br.com.saude.prontuario.model.repository.impls;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.saude.prontuario.model.entities.ParametroRepasse;
import br.com.saude.prontuario.model.entities.QParametroRepasse;
import br.com.saude.prontuario.model.entities.SegmentoEnum;
import br.com.saude.prontuario.model.repository.interfaces.ParametroRepasseRepository;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional(readOnly = true)
public class ParametroRepasseRepositoryImpl extends
		QueryDslJpaRepository<ParametroRepasse, Long> implements
		ParametroRepasseRepository {

	private final QParametroRepasse qParametroRepasse = QParametroRepasse.parametroRepasse;

	@Inject
	public ParametroRepasseRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<ParametroRepasse, Long>(
				ParametroRepasse.class, entityManager.getMetamodel()),
				entityManager);
	}

	@Override
	public List<ParametroRepasse> buscarPorNome(String nome) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (nome != null)
			predicate.or(qParametroRepasse.descricao.containsIgnoreCase(nome));
		predicate.or(qParametroRepasse.ativo.eq(true));
		return createQuery(predicate)
				.orderBy(qParametroRepasse.descricao.asc()).listDistinct(
						qParametroRepasse);
	}

	@Override
	public List<ParametroRepasse> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("descricao"))
			predicate.and(qParametroRepasse.descricao
					.lower()
					.trim()
					.like(String.format("%%%s%%", params.get("descricao")
							.toString().toLowerCase().trim())));
		if (params.containsKey("valorRepasse"))
			predicate.and(qParametroRepasse.valorRepasse.eq((BigDecimal) params
					.get("valorRepasse")));
		if (params.containsKey("segmento"))
			predicate.and(qParametroRepasse.segmento.eq((SegmentoEnum) params
					.get("segmento")));
		if (params.containsKey("codUnidade"))
			predicate.and(qParametroRepasse.codUnidade.trim().eq(
					params.get("codUnidade").toString().trim()));
		if (params.containsKey("codAtividade"))
			predicate.and(qParametroRepasse.codAtividade.trim().eq(
					params.get("codAtividade").toString().trim()));
		if (params.containsKey("codElementoDespesa"))
			predicate.and(qParametroRepasse.codElementoDespesa.trim().eq(
					params.get("codElementoDespesa").toString().trim()));
		if (params.containsKey("codFonteRecurso"))
			predicate.and(qParametroRepasse.codFonteRecurso.trim().eq(
					params.get("codFonteRecurso").toString().trim()));
		if (params.containsKey("exercicio"))
			predicate.and(qParametroRepasse.exercicio.eq(Integer
					.parseInt(params.get("exercicio").toString())));
		predicate.and(qParametroRepasse.ativo.eq(true));
		return createQuery(predicate)
				.orderBy(qParametroRepasse.descricao.asc()).listDistinct(
						qParametroRepasse);
	}

	@Override
	public List<ParametroRepasse> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.or(qParametroRepasse.descricao.containsIgnoreCase(valor));
		predicate.or(qParametroRepasse.ativo.eq(true));
		return createQuery(predicate)
				.orderBy(qParametroRepasse.descricao.asc()).listDistinct(
						qParametroRepasse);
	}

	@Override
	public List<ParametroRepasse> autocompletar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("valor"))
			predicate.and(qParametroRepasse.descricao.containsIgnoreCase(params
					.get("valor").toString()));
		if (params.containsKey("segmento"))
			predicate.and(qParametroRepasse.segmento.eq((SegmentoEnum) params
					.get("segmento")));
		predicate.and(qParametroRepasse.ativo.eq(true));
		return createQuery(predicate)
				.orderBy(qParametroRepasse.descricao.asc()).listDistinct(
						qParametroRepasse);
	}
}
