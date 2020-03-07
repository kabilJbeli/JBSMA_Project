package com.contrat.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;

import com.contrat.entities.Contrat;

/**
 * Session Bean implementation class ContratManagement
 */
@Stateless
@LocalBean
public class ContratManagement implements ContratManagementLocal {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JBSMA");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	/**
	 * Default constructor.
	 */
	public ContratManagement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(Contrat c) {

		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Contrat cust = null;
		cust = em.find(Contrat.class, ((Contrat) c).getNUMEROCONTRAT());
		em.remove(cust);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public int update(Contrat c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contrat findByName(String name) {
		return null;
	}

	@Override
	public void creation(Contrat c) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(((Contrat) c));
		em.getTransaction().commit();
		em.close();

	}

}
