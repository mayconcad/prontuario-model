package br.com.sts.ddum.model.repository.impls;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import br.com.sts.ddum.model.repository.interfaces.UserRepository;
import br.com.sts.ddum.model.springsecurity.entities.QUser;
import br.com.sts.ddum.model.springsecurity.entities.User;

import com.mysema.query.BooleanBuilder;

//import br.com.sts.ddum.model.entities.QUserSystem;

@Repository
public class UserRepositoryImpl extends QueryDslJpaRepository<User, Long>
		implements UserRepository {

	@Inject
	private EntityManager em;

	private static QUser user = QUser.user;

	@Inject
	public UserRepositoryImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<User, Long>(User.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public User loadUserByUsername(String username) {
		return createQuery(user.username.eq(username)).singleResult(user);
		// return null;
	}

	@Override
	public void changePassword(String username, String newPassword) {
		Query createQuery = em
				.createQuery("SELECT * FROM usersystem WHERE username LIKE :username");
		createQuery.setParameter("username", username);

		List<User> users = createQuery.getResultList();
		User userSystem = users.get(0);
		userSystem.setPassword(newPassword);
		this.save(userSystem);
		// new JPAUpdateClause(em, user).where(user.username.eq(username))
		// .set(user.password, newPassword).execute();
	}

	@Override
	public User loadCurrentUser() {
		String username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		return loadUserByUsername(username);
	}

	@Override
	public List<User> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("name"))
			predicate.and(user.name.lower().like(
					params.get("name").toString().toLowerCase()));
		if (params.containsKey("username"))
			predicate.and(user.username.lower().like(
					params.get("userName").toString().toLowerCase()));
		if (params.containsKey("dataInicial")
				&& !params.containsKey("dataFinal"))
			predicate
					.and(user.createdAt.after((Date) params.get("dataInicial")));
		if (!params.containsKey("dataInicial")
				&& params.containsKey("dataFinal"))
			predicate
					.and(user.createdAt.before((Date) params.get("dataFinal")));
		if (params.containsKey("dataInicial")
				&& params.containsKey("dataFinal"))
			predicate.and(user.createdAt.between(
					(Date) params.get("dataInicial"),
					(Date) params.get("dataFinal")));
		if (params.containsKey("principalRole"))
			predicate.and(user.roles.any().role.name.eq(params.get(
					"principalRole").toString()));
		predicate.and(user.ativo.eq(true));
		return createQuery(predicate).orderBy(user.username.asc())
				.listDistinct(user);
	}
}