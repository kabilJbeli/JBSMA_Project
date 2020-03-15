package com.contrat.dao;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.contrat.entities.Contrat;
import com.contrat.entities.Produit;

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
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			Query query = entityManager.createNativeQuery("select * from produit", Produit.class);
			List<Produit> produits = query.getResultList();
			userTxn.commit();
			return produits;
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
	public void Creation(Produit produit) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().persist(produit);
			userTxn.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				userTxn.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Produit produit) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().remove(getEntityManager().find(Produit.class, produit.getIDCONF()));			
			userTxn.commit();
			FacesContext.getCurrentInstance().addMessage("productManagement", new FacesMessage("The product has been deleted"));
		} catch (Throwable e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("productManagement", new FacesMessage("This product is attached to a contract is should not be deleted"));
			try {
				userTxn.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void modifier(Produit produit) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().merge(produit);
			userTxn.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				userTxn.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
