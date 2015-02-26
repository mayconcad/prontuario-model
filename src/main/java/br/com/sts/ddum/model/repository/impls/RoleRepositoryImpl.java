package br.com.sts.ddum.model.repository.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sts.ddum.model.repository.interfaces.RoleRepository;
import br.com.sts.ddum.model.springsecurity.entities.QRole;
import br.com.sts.ddum.model.springsecurity.entities.Role;

import com.mysema.query.BooleanBuilder;

//import br.com.sts.ddum.model.entities.QUserSystem;

@Repository
public class RoleRepositoryImpl extends QueryDslJpaRepository<Role, Long>
		implements RoleRepository {

	@Inject
	private EntityManager em;

	private static QRole role = QRole.role;

	@Inject
	public RoleRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Role, Long>(Role.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public List<Role> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("name"))
			predicate.and(role.name.lower().like(
					params.get("name").toString().toLowerCase()));
		predicate.and(role.ativo.eq(true));
		return createQuery(predicate).orderBy(role.name.asc()).listDistinct(
				role);
	}

	@Override
	public List<Role> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(role.name.containsIgnoreCase(valor));
		predicate.and(role.ativo.eq(true));
		return createQuery(predicate).orderBy(role.name.asc()).listDistinct(
				role);
	}
}