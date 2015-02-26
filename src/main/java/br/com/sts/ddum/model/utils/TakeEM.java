package br.com.sts.ddum.model.utils;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

@Component
public class TakeEM {
	
	private EntityManager entityManager;
	
	static protected TakeEM takeEM;
	
	@Inject
	public TakeEM(EntityManager entityManager) {
		this.entityManager = entityManager;
		TakeEM.takeEM = this;
	}
		
	public static EntityManager retrieveEM() {
		return takeEM.entityManager;
		
	}

}
