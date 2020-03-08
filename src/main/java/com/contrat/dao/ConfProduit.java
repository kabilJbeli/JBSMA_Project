package com.contrat.dao;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
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
import com.tier.entities.Tier;

/**
 * Session Bean implementation class ConfProduit
 */
@Stateless
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ConfProduit implements ConfProduitLocal {
	@PersistenceContext(unitName = "JBSMA")
	EntityManager entityManager;
	@Resource
	private SessionContext sessionContext;

	public ConfProduit() {
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Produit rechercheProduit(int idproduit) {
		Produit produit = new Produit();
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			produit = getEntityManager().find(Produit.class, idproduit);
			userTxn.commit();
			return produit;
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				userTxn.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Produit> rechercheProduits() {
		Query query = entityManager.createNativeQuery("select * from produit", Produit.class);
		return query.getResultList();
}

}
