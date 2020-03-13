package com.comptabilite.dao;

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

import com.comptabilite.entities.Encaissement;
import com.comptabilite.entities.Facture;
import com.contrat.entities.Contrat;
import com.contrat.entities.Echeance;
import com.contrat.entities.Produit;

/**
 * Session Bean implementation class FactureManagement
 */
@Stateless
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class FactureManagement implements FactureManagementLocal {
	@PersistenceContext(unitName = "JBSMA")
	EntityManager entityManager;
	@Resource
	private SessionContext sessionContext;

    /**
     * Default constructor. 
     */
    public FactureManagement() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public List<Facture> FindbyContract(Contrat contrat) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			Query query = entityManager.createNativeQuery("select f.* from contrat c, echeance e, facture f where c.idcontrat = e.contrat_IDCONTRAT and e.idecheance = f.ECHEANCE_IDECHEANCE and c.idcontrat = ?", Facture.class).setParameter(1, contrat.getIDCONTRAT());
			List<Facture> factures = query.getResultList();
			userTxn.commit();
			return factures;
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
	public void creation(Facture facture) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().persist(facture);
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
	public void modification(Facture facture) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().merge(facture);
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
	public Facture findbyID(int idfacture) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			Facture facture = getEntityManager().find(Facture.class, idfacture);
			userTxn.commit();
			return facture;
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

}
