package com.contrat.dao;

import java.time.LocalDate;
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
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.contrat.entities.Contrat;
import com.contrat.entities.Echeance;
import com.tier.entities.Tier;

/**
 * Session Bean implementation class EchanceManagement
 */
@Stateless
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class EchanceManagement implements EchanceManagementLocal {
	@PersistenceContext(unitName = "JBSMA")
	EntityManager entityManager;
	@Resource
	private SessionContext sessionContext;

    /**
     * Default constructor. 
     */
    public EchanceManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void creation(Echeance echance) {
		echance.setStatus(0);
		entityManager.persist(echance);		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Echeance RechercheEcheance(int idEch) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();			
			Echeance ech = getEntityManager().find(Echeance.class, idEch);
			userTxn.commit();
			return ech;
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
	public List<Echeance> RechercheEcheanceparDateContrat(Contrat contrat) {
		List<Echeance> tier = null;
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();			
			Query query = getEntityManager().createNativeQuery("select e.* from echeance e where e.contrat_IDCONTRAT = ?");
			query.setParameter(1, contrat.getIDCONTRAT());
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
	public void Modify(Echeance c) {
		// TODO Auto-generated method stub
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().merge(c);
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
