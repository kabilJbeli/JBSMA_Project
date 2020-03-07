package com.tier.dao;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tier.entities.Tier;

@LocalBean
@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class TierManagement implements TierManagementLocal {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JBSMA");
	EntityManager entityManager = emf.createEntityManager();

	/**
	 * Default constructor.
	 */
	public TierManagement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(Tier T) {
		entityManager.remove(T);

	}

	@Override
	public void update(Tier T) {
		entityManager.merge(T);
	}

	@Override
	public Tier findByName(String name) {
		return entityManager.find(Tier.class, 1);
	}

	@Override
	public void creation(Tier T) {
		entityManager.persist(T);
	}
}
