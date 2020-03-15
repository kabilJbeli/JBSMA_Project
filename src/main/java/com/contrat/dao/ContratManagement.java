package com.contrat.dao;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.contrat.entities.Contrat;
import com.tier.entities.Tier;

/**
 * Session Bean implementation class ContratManagement
 */
@Stateless
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ContratManagement implements ContratManagementLocal {
	@PersistenceContext(unitName = "JBSMA")
	EntityManager entityManager;
	@Resource
	private SessionContext sessionContext;

	/**
	 * Default constructor.
	 */
	public ContratManagement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(Contrat contrat) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().remove(contrat);
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
	public void update(Contrat contrat) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().merge(contrat);
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
	public Contrat findByName(String name) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			Query query = getEntityManager()
					.createNativeQuery("select * from contrat where NUMEROCONTRAT = ?", Contrat.class)
					.setParameter(1, name);
			Contrat contrat =  (Contrat) query.getSingleResult();
			userTxn.commit();
			return contrat;

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
	public void creation(Contrat contrat) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().persist(contrat);
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

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Contrat> contractList() {
		// TODO Auto-generated method stub
		Query query = getEntityManager().createNativeQuery("select * from contrat", Contrat.class);
		return query.getResultList();
	}
	
		@Override
	public BigInteger getNext() {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
	    Query query =  getEntityManager().createNativeQuery("select max(next_val)+1 as num from hibernate_sequence");
	    BigInteger nextval = (BigInteger) query.getSingleResult();
	    userTxn.commit();
	    return nextval;
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				userTxn.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				e1.printStackTrace();
			}
		}
		return BigInteger.valueOf(0);
	}
}
