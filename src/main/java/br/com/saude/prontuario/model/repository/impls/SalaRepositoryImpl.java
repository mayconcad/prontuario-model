package br.com.saude.prontuario.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.saude.prontuario.model.entities.Sala;
import br.com.saude.prontuario.model.entities.QSala;
import br.com.saude.prontuario.model.repository.interfaces.SalaRepository;

import com.mysema.query.BooleanBuilder;

//import br.com.sts.prontuario.model.entities.QUserSystem;

@Repository
@Transactional(readOnly = true)
public class SalaRepositoryImpl extends QueryDslJpaRepository<Sala, Long>
		implements SalaRepository {

	@Inject
	private EntityManager em;

	private static QSala Sala = QSala.sala;

	@Inject
	public SalaRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Sala, Long>(Sala.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public List<Sala> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("descricao"))
			predicate.and(Sala.descricao.lower().like(
					params.get("descricao").toString().toLowerCase()));
		predicate.and(Sala.ativo.eq(true));
		return createQuery(predicate).orderBy(Sala.descricao.asc()).listDistinct(
				Sala);
	}

	@Override
	public List<Sala> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(Sala.descricao.containsIgnoreCase(valor));
		predicate.and(Sala.ativo.eq(true));
		return createQuery(predicate).orderBy(Sala.descricao.asc()).listDistinct(
				Sala);
	}
}