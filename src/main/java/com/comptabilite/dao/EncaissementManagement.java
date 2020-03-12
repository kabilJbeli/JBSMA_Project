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

/**
 * Session Bean implementation class EncaissementManagement
 */
@Stateless
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class EncaissementManagement implements EncaissementManagementLocal {
	@PersistenceContext(unitName = "JBSMA")
	EntityManager entityManager;
	@Resource
	private SessionContext sessionContext;


    /**
     * Default constructor. 
     */
    public EncaissementManagement() {
        // TODO Auto-generated constructor stub
    }
    
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void modification(Encaissement encaissement) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().merge(encaissement);
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
	public List<Encaissement> FindbyContract(Contrat contrat) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			Query query = entityManager.createNativeQuery("select en.* from contrat c, echeance e, facture f, encaissement en where c.idcontrat = e.contrat_IDCONTRAT and e.idecheance = f.ECHEANCE_IDECHEANCE and f.idfacture=en.Facture_IDFACTURE and c.idcontrat = ?", Facture.class).setParameter(1, contrat.getIDCONTRAT());
			List<Encaissement> encaissement = query.getResultList();
			userTxn.commit();
			return encaissement;
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
	public Encaissement FindbyFacture(Facture facture) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			Query query = entityManager.createNativeQuery("select en.* from facture f, encaissement en where f.idfacture=en.Facture_IDFACTURE and f.idfacture = ?", Encaissement.class).setParameter(1, facture.getIDFACTURE());
			Encaissement encaissement = (Encaissement) query.getSingleResult();
			userTxn.commit();
			return encaissement;
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
	public void creation(Encaissement encaissement) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			getEntityManager().persist(encaissement);
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
	public Encaissement findbyID(int idencaissement) {
		UserTransaction userTxn = sessionContext.getUserTransaction();
		try {
			userTxn.begin();
			Encaissement encaissement = entityManager.find(Encaissement.class, idencaissement);
			userTxn.commit();
			return encaissement;
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
