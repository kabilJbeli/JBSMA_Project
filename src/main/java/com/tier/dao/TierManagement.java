package com.tier.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import com.tier.entities.Tier;

@Stateless
@LocalBean
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
		Tier cust = null;
		if (entityManager.getTransaction().isActive() == false) {
			entityManager.getTransaction().begin();
		}
		cust = entityManager.find(Tier.class, ((Tier) T).getCINTIER());
		entityManager.remove(cust);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(Tier T) {
		Tier cust = null;
		if (entityManager.getTransaction().isActive() == false) {
			entityManager.getTransaction().begin();
		}
			cust = entityManager.find(Tier.class, T.getIDTIER());
			entityManager.merge(cust);
			entityManager.getTransaction().commit();
	}

	@Override
	public Tier findByName(String name) {
		Tier cust = null;
		if (entityManager.getTransaction().isActive() == false) {
			entityManager.getTransaction().begin();
		}
		cust = entityManager.find(Tier.class, name);
		return cust;
	}

	@Override
	public void creation(Tier T) {
		if (entityManager.getTransaction().isActive() == false) {
			entityManager.getTransaction().begin();
		}
		entityManager.persist(T);

	}
}
