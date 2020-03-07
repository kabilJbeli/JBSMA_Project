package com.contrat.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.contrat.entities.Echeance;

/**
 * Session Bean implementation class EchanceManagement
 */
@Stateless
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class EchanceManagement implements EchanceManagementLocal {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JBSMA");
	EntityManager entityManager = emf.createEntityManager();

    /**
     * Default constructor. 
     */
    public EchanceManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void creation(Echeance echance) {
		entityManager.persist(echance);
		
	}

}
