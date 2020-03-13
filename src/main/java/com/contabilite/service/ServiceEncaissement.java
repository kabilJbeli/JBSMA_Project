package com.contabilite.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.comptabilite.dao.EncaissementManagementLocal;
import com.comptabilite.entities.Encaissement;
import com.comptabilite.entities.Facture;
import com.contrat.entities.Contrat;

/**
 * Session Bean implementation class ServiceEncaissement
 */
@Stateless
@LocalBean
public class ServiceEncaissement implements ServiceEncaissementLocal {
	@EJB
	EncaissementManagementLocal encaissementManagemendao;

    /**
     * Default constructor. 
     */
    public ServiceEncaissement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void modificationEncaissement(Encaissement encaissement) {
		encaissementManagemendao.modification(encaissement);		
	}

	@Override
	public List<Encaissement> RechercheEncaissementparContract(Contrat contrat) {
		// TODO Auto-generated method stub
		return encaissementManagemendao.FindbyContract(contrat);
	}

	@Override
	public Encaissement RechercheEncaissementparFacture(Facture facture) {
		// TODO Auto-generated method stub
		return encaissementManagemendao.FindbyFacture(facture);
	}

	@Override
	public void creationEncaissement(Encaissement encaissement) {
		encaissementManagemendao.creation(encaissement);
		
	}

	@Override
	public Encaissement RechercheEncaissementparID(int encaissement) {
		// TODO Auto-generated method stub
		return encaissementManagemendao.findbyID(encaissement);
	}

}
