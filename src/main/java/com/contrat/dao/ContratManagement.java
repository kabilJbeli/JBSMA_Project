package com.contrat.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;

import com.contrat.entities.Contrat;
import com.contrat.entities.Produit;

/**
 * Session Bean implementation class ContratManagement
 */
@Stateless
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ContratManagement implements ContratManagementLocal {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JBSMA");
	EntityManager entityManager = emf.createEntityManager();



	/**
	 * Default constructor.
	 */
	public ContratManagement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(Contrat contrat) {
		entityManager.remove(contrat);
	}

	@Override
	public void update(Contrat contrat) {
		entityManager.merge(contrat);
	}

	@Override
	public Contrat findByName(String name) {
		Query query = entityManager.createNativeQuery("select * from contrat where NUMEROCONTRAT = ?", Contrat.class).setParameter("NUMEROCONTRAT", name);
		return (Contrat) query.getSingleResult();
	}

	@Override
	public void creation(Contrat contrat) {
		entityManager.persist(contrat);
		}

}
