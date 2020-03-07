package com.contrat.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.contrat.dao.EchanceManagementLocal;
import com.contrat.entities.Echeance;

/**
 * Session Bean implementation class ServiceEcheance
 */
@Stateless
@LocalBean
public class ServiceEcheance implements ServiceEcheanceLocal {
	EchanceManagementLocal daoEchance;

    /**
     * Default constructor. 
     */
    public ServiceEcheance() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void creation(Echeance echance) {
		daoEchance.creation(echance);
		
	}

}
