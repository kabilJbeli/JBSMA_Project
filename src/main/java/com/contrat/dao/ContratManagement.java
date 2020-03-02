package com.contrat.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.contrat.entities.Contrat;

/**
 * Session Bean implementation class ContratManagement
 */
@Stateless
@LocalBean
public class ContratManagement implements ContratManagementLocal {
	@PersistenceContext
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JBSMA");
	EntityManager em = emf.createEntityManager() ;

    /**
     * Default constructor. 
     */
    public ContratManagement() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void delete (Contrat c) {
        EntityTransaction et = null;
        Contrat cust = null;
 
        try {
            et = em.getTransaction();
            et.begin();
            cust = em.find(Contrat.class, ((Contrat)c).getNUMEROCONTRAT());
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
	public int update(Contrat c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contrat findByName(String name) {
		return null;
	}

	@Override
	public void creation(Contrat c) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            em.persist(((Contrat)c));
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
