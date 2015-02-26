package br.com.sts.ddum.model.repository.impls;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.model.entities.AuthoritySystem;
import br.com.sts.ddum.model.repository.interfaces.AclRepository;

@Repository
@Transactional(readOnly = true)
public class AclRepositoryImpl extends
		QueryDslJpaRepository<AuthoritySystem, Long> implements AclRepository {

	@Inject
	public AclRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<AuthoritySystem, Long>(
				AuthoritySystem.class, entityManager.getMetamodel()),
				entityManager);
	}

}
