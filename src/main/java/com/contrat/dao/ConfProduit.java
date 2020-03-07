package com.contrat.dao;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.hibernate.Session;

import com.contrat.entities.Produit;

/**
 * Session Bean implementation class ConfProduit
 */
@Stateless
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ConfProduit implements ConfProduitLocal {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JBSMA");
	EntityManager entityManager = emf.createEntityManager();

	public ConfProduit() {
	}

	@Override
	public Produit rechercheProduit(String nomProduit) {
		Produit cust = null;
		if (entityManager.getTransaction().isActive() == false) {
			entityManager.getTransaction().begin();
		}
		cust = entityManager.find(Produit.class, nomProduit);
		entityManager.getTransaction().commit();
		return cust;

	}

	@Override
	public List<Produit> rechercheProduits() {
		List<Produit> cust = null;
		if (entityManager.getTransaction().isActive() == false) {
			entityManager.getTransaction().begin();
		}
		Query query = entityManager.createNativeQuery("select * from produit", Produit.class);
		cust = query.getResultList();
		entityManager.getTransaction().commit();
		return cust;
	}

}
