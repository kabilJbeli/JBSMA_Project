package com.contrat.service;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.contrat.dao.ContratManagementLocal;
import com.contrat.entities.Contrat;
import com.contrat.entities.Echeance;
import com.contrat.entities.Produit;
import com.contrat.entities.Tier;

/**
 * Session Bean implementation class ServiceContrat
 */
@Stateless
@LocalBean
public class ServiceContrat implements ServiceContratLocal {
	@EJB
	ContratManagementLocal daoContrat;


    public ServiceContrat() {
    }
    
    @Override
    public List<Echeance> CalculeMensualite(Contrat contrat) {
    	double montantfinancement = contrat.getMTFINANCEMENT();
//    	Produit produit = contrat.getProduit();
//    	double tauxinteret = Math.IEEEremainder(produit.getTAUXCOMM(),100);
    	double tauxinteret = Math.IEEEremainder(10,100);
    	List<Echeance> echances = new LinkedList<Echeance>();
    	int duree = contrat.getDUREE();
    	
    	for (int i = 0;i<duree;i++) {
    		Echeance echeance = new Echeance();
    		double mensualite = (montantfinancement * (tauxinteret/12))/ (1 - (1 + Math.pow((tauxinteret/12), - duree)));
    		echeance.setMTTTC(mensualite);
    		echances.add(echeance);
    	}
		return echances;
    	
    }
    
    @Override
    public void CreationContrat (Contrat contrat,Produit produit,Tier tier) {
    	
    	contrat.setTier(tier);
    	contrat.setProduit(produit);
    	contrat.setEcheances(CalculeMensualite(contrat));
    	daoContrat.creation(contrat);


    }

}
