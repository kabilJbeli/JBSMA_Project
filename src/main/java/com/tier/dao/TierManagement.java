package com.tier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import com.contrat.entities.Tier;

public class TierManagement implements TierManagementLocal{
	@PersistenceContext
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JBSMA");
	EntityManager em = emf.createEntityManager() ;

    /**
     * Default constructor. 
     */
    public TierManagement() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void delete (Tier T) {
        EntityTransaction et = null;
        Tier cust = null;
 
        try {
            et = em.getTransaction();
            et.begin();
            cust = em.find(Tier.class, ((Tier)T).getCINTIER());
            em.remove(cust);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
	}

	@Override
	public Tier update(Tier T) {
		// TODO Auto-generated method stub		
		   EntityTransaction et = null;
	        Tier cust = null;
	        Tier merged = null;
	        try {
	            et = em.getTransaction();
	            et.begin();
	            cust = em.find(Tier.class, T.getCINTIER());
	            merged =  em.merge(cust);	
	            et.commit();
	    		
	        } catch (Exception ex) {
	            if (et != null) {
	                et.rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            em.close();
	        }
		return merged;
	}

	@Override
	public Tier findByCIN(Integer CIN) {		
		   EntityTransaction et = null;
	        Tier cust = null;
	 
	        try {
	            et = em.getTransaction();
	            et.begin();
	            cust = em.find(Tier.class, CIN);
	            et.commit();
	    		
	        } catch (Exception ex) {
	            if (et != null) {
	                et.rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            em.close();
	        }
	        return cust;
	}

	@Override
	public void creation(Tier T) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            em.persist(((Tier)T));
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
		
	}
}
