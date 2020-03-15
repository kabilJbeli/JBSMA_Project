package com.tier.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.persistence.Query;
import com.contrat.entities.Produit;
import com.tier.entities.Tier;

@Stateless
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class TierManagement implements TierManagementLocal {
	@PersistenceContext(unitName = "JBSMA")
	EntityManager entityManager;
	@Resource
	private SessionContext sessionContext;

	/**
	 * Default constructor.
	 */
	public TierManagement() {
		// TODO Auto-generated constructor stub
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void delete(Tier T) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().remove(getEntityManager().find(Tier.class, T.getIDTIER()));;
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
	public void update(Tier T) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().merge(T);
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
	public List<Tier> findByName(String name) {
		List<Tier> tier = null;
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();			
			Query query = getEntityManager().createNativeQuery("select * from Tier where NAMETIER=?").setParameter(1, name);
			tier = query.getResultList();
			userTxn.commit();			
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				userTxn.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				e1.printStackTrace();
			}
		}
		return tier;
	}

	@Override
	public void creation(Tier T) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().persist(T);
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
	public List<Tier> getAll() {
		// TODO Auto-generated method stub	
		Query query = entityManager.createNativeQuery("select * from Tier", Tier.class);
		return query.getResultList();
	}

	@Override
	public Tier findByCIN(String CIN) {
		Tier tier = null;
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();			
			tier = (Tier) getEntityManager().createQuery("SELECT t FROM Tier t where t.CINTIER = :cin").setParameter("cin", CIN).getSingleResult();
			userTxn.commit();			
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				userTxn.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				e1.printStackTrace();
			}
		}
		return tier;
	}
}
